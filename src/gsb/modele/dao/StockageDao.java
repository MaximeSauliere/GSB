package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import gsb.modele.Medicament;
import gsb.modele.Stockage;
import gsb.modele.Visiteur;

public class StockageDao {
	
	public static Stockage rechercher(String depotlegal){
		Stockage unStockage=null;
		Medicament leMedicament = null;
		Visiteur leVisiteur = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Stocker where DEPOTLEGAl = '"+depotlegal+"'");
		try {
			if (reqSelection.next()) {
				leVisiteur = VisiteurDao.rechercher(reqSelection.getString(2));
				leMedicament = MedicamentDao.rechercher(reqSelection.getString(3));
				unStockage = new Stockage(reqSelection.getString(1),leVisiteur,leMedicament);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from Stocker where qtestock='"+depotlegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unStockage;
	}
	
	public static int creer(Stockage unStockage){
		int result = 0;
		String requeteInsertion;
		String qte = unStockage.getQte();
		String leMedicament = unStockage.getLeMedicament().getDepotLegal();
		String leVisiteur = unStockage.getLeVisiteur().getMatricule();
		requeteInsertion = "insert into stocker values('"+qte+"','"+leVisiteur+"','"+leMedicament+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Stocker");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static HashMap<String,Stockage> retournerDictionnaireDesStockage(){
		HashMap<String, Stockage> diccoDesStockage = new HashMap<String, Stockage>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from Stocker");
		try{
		while (reqSelection.next()) {
			String depotlegal = reqSelection.getString(1);
			Stockage unStockage = StockageDao.rechercher(depotlegal);
		    diccoDesStockage.put(depotlegal, unStockage);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesStockage()");
		}
		return diccoDesStockage;
	}
	
	public static int supprimer(String qte){
		String requeteSuppression = "delete from Stocker where qtestock ='"+qte+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Stockage unStockage){
		String requeteModification;
		String qte = unStockage.getQte();
		Medicament leMedicament = unStockage.getLeMedicament();
		Visiteur leVisiteur = unStockage.getLeVisiteur();
		requeteModification = "update Localite set qtestock ='"+qte+"','"+leMedicament+"','"+leVisiteur+"')";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
