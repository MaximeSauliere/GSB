package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Localite;
import gsb.modele.Unite;

public class VisiteurDao {
	
	public static Visiteur rechercher(String codeVisiteur){
		Visiteur unVisiteur = null;
		Unite uneUnitee = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='"+codeVisiteur+"'");
		try {
			if (reqSelection.next()) {
				uneUnite = UniteDao.rechercher(reqSelection.getString(10));
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getDate(8), reqSelection.getInt(9), uneUnite);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"+codeVisiteur+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static ArrayList<Visiteur> retournerCollectionDesVisiteur(){
		ArrayList<Visiteur> collectionDesVisiteur = new ArrayList<Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeVisiteur = reqSelection.getString(1);
		    collectionDesVisiteur.add(MedecinDao.rechercher(codeVisiteur));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesVisiteur;
	}
	
	public static HashMap<String,Visiteur> retournerDictionnaireDesVisiteur(){
		HashMap<String, Visiteur> diccoDesMedecins = new HashMap<String, Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from Visiteur");
		try{
		while (reqSelection.next()) {
			String codeVisiteur = reqSelection.getString(1);
		    diccoDesVisiteur.put(codeVisiteur, MedecinDao.rechercher(codeVisiteur));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesVisiteur;
	}

}

}
