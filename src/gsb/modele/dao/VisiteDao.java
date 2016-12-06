package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;


public class VisiteDao {
	
	public static Visite rechercher(String reference){
		Visite uneVisite=null;
		Visiteur unVisiteur=null;
		Medecin unMedecin=null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE where REFERENCE='"+reference+"'");
		try {
			if (reqSelection.next()) {
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(4));
				unMedecin = MedecinDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2),reqSelection.getString(3), unVisiteur, unMedecin);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from Visite where Reference='"+reference+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	public static int creer(Visite uneVisite){
		int result = 0;
		String requeteInsertion;
		
		String reference = uneVisite.getReference();
		String date = uneVisite.getDate();
		String commentaire = uneVisite.getCommentaire();
		Visiteur unVisiteur = uneVisite.getUnVisiteur();
		Medecin unMedecin = uneVisite.getUnMedecin();

		requeteInsertion = "insert into Visite values('"+reference+"','"+date+"','"+commentaire+"','"+unVisiteur+"','"+unMedecin+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Visite");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int supprimer(String reference){
		String requeteSuppression = "delete from Visite where ='"+reference+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Visite uneVisite){
		String requeteModification;
		
		String reference = uneVisite.getReference();
		String date = uneVisite.getDate();
		String commentaire = uneVisite.getCommentaire();
		Visiteur unVisiteur = uneVisite.getUnVisiteur();
		Medecin unMedecin = uneVisite.getUnMedecin();
	
		requeteModification = "update Visite set reference  = '"+reference+"','"+date+"','"+commentaire+"','"+unVisiteur+"','"+unMedecin+"')";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}


}
