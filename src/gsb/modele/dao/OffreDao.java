package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medicament;
import gsb.modele.Offre;
import gsb.modele.Visite;


public class OffreDao {
	
	public static Offre rechercher(int qteOfferte){
		Medicament unMedicament=null;
		Visite uneVisite= null;
		Offre uneOffre = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Offre where quantiteOfferte ='"+qteOfferte+"'");
		try {
			if (reqSelection.next()) {
				unMedicament = MedicamentDao.rechercher(reqSelection.getString(2));
				uneVisite = VisiteDao.rechercher(reqSelection.getString(2));

				uneOffre = new Offre(reqSelection.getInt(1),unMedicament,uneVisite );	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from Offre where quantiteOfferte ='"+qteOfferte+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneOffre;
	}
	
	public static int creer(Offre uneOffre){
		int result = 0;
		String requeteInsertion;
		int qteOfferte = uneOffre.getQteOfferte();
		requeteInsertion = "insert into Offre values('"+qteOfferte+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Offre");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
		}

	public static int supprimer(int qteOffre){
		String requeteSuppression = "delete from Offre where ='"+qteOffre+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static int modifier(Offre uneOffre){
		String requeteModification;
		int qteOfferte = uneOffre.getQteOfferte();
		requeteModification = "update Offre set qteOfferte ='"+qteOfferte+"')";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}