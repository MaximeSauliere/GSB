package gsb.tests.dao;

import java.util.HashMap;
import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

public class MedecinDaoTest {

	public static void main(String[] args) {
		
		Localite Quimper = new Localite("56600","Quimper");
		Medecin Gerard = new Medecin ("m106","drareg","gerard","11 rue du vonlla",Quimper,"0607080910","potentiel","pro");
		HashMap<String,Medecin> unDicco = new HashMap<String,Medecin>();
		unDicco =	MedecinDao.retournerDictionnaireDesMedecins();
		
		if (unDicco.containsKey("m002")){
			System.out.println(unDicco.get("m002").getNom());
		}
		
		MedecinDao.creer(Gerard);
		Gerard = new Medecin ("m106","gerard","drareg","11 rue du vallon",Quimper,"0607080910","pot","protentiel");
		MedecinDao.modifier(Gerard);
		MedecinDao.supprimer(Gerard.getCodeMed());
		
	}
	
}
