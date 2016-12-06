package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import gsb.modele.Medecin;
import gsb.modele.Medicament;

public class MedicamentDao {
	
	public static Medicament rechercher(String depotLegal){
		Medicament unMedicament = null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Medicament where DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4),reqSelection.getString(5),reqSelection.getString(6),reqSelection.getString(7),reqSelection.getString(8));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from Medicament where DEPOTLEGAL ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	public static int creer(Medicament unMedicament){
		int result = 0;
		String requeteInsertion;
		
		String depotLegal = unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		String prixEchantillion = unMedicament.getPrixEchantillon();
		String unCodeFamille = unMedicament.getCodeFamille();
		String unLibelleFamille = unMedicament.getLibelleFamille();

		requeteInsertion = "insert into Affaire values('"+depotLegal+"','"+nomCommercial+"','"+composition+"','"+effets+"','"+contreIndication+"','"+prixEchantillion+"','"+unCodeFamille+"','"+unLibelleFamille+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Medicament");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static HashMap<String,Medicament> retournerDictionnaireDesMedicament(){
		HashMap<String, Medicament> diccoDesMedicament = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
		    diccoDesMedicament.put(codeMedicament, MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicament()");
		}
		return diccoDesMedicament;
	}
	
	public static int supprimer(String depotLegal){
		String requeteSuppression = "delete from Medicament where ='"+depotLegal+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Medicament unMedicament){
		String requeteModification;
		
		String depotLegal = unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		String prixEchantillion = unMedicament.getPrixEchantillon();
		String unCodeFamille = unMedicament.getCodeFamille();
		String unLibelleFamille = unMedicament.getLibelleFamille();

		
		requeteModification = "update Famille set depotLegal  = '"+depotLegal+"','"+nomCommercial+"','"+composition+"','"+effets+"','"+contreIndication+"','"+prixEchantillion+"','"+unCodeFamille+"','"+unLibelleFamille+"')";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
