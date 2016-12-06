package gsb.tests.dao;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Localite Lorient = new Localite ("56 600","Lorient");
		
		LocaliteDao.creer(Lorient);
		Lorient = new Localite ("56 600","Lorient");

		
		LocaliteDao.modifier(Lorient);
		LocaliteDao.supprimer(Lorient.getCodePostal());


	}

}
