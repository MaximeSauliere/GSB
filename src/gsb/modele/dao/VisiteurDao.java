package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Visiteur;

public class VisiteurDao {
	
	public static Visiteur rechercher(String matricule){
		Visiteur unVisiteur = null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='"+matricule+"'");
		try {
			if (reqSelection.next()) {
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"+matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static int creer(Visiteur unVisiteur){
		int result = 0;
		String requeteInsertion;
		
		String matricule = unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login = unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		String adresse = unVisiteur.getAdresse();
		String telephone = unVisiteur.getTelephone();
		String dateEntree = unVisiteur.getDateEntree();

		requeteInsertion = "insert into Visite values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+telephone+"','"+dateEntree+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Visiteur");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int supprimer(String matricule){
		String requeteSuppression = "delete from Visiteur where ='"+matricule+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Visiteur unVisiteur){
		String requeteModification;
		
		String matricule = unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login = unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		String adresse = unVisiteur.getAdresse();
		String telephone = unVisiteur.getTelephone();
		String dateEntree = unVisiteur.getDateEntree();
	
		requeteModification = "update Visiteur set reference  = '"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+telephone+"','"+dateEntree+"')";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	
}