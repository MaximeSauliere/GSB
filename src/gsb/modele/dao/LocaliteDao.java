package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Localite;

/**
 * @author Isabelle
 * 22 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class LocaliteDao {
	
	public static Localite rechercher(String codeLocalite){
		Localite uneLocalite=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}
	
	public static int creer(Localite uneLocalite){
		int result = 0;
		String requeteInsertion;
		String codePostal = uneLocalite.getCodePostal();
		String ville = uneLocalite.getVille();
		requeteInsertion = "insert into Affaire values('"+codePostal+"','"+ville+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Localite");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int supprimer(String codePostal){
		String requeteSuppression = "delete from Localite where ='"+codePostal+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Localite uneLocalite){
		String requeteModification;
		String codePostal= uneLocalite.getCodePostal();
		String ville = uneLocalite.getVille();
		requeteModification = "update Localite set codePostal ='"+codePostal+"',ville='"+ville+"'";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}


}