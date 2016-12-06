package gsb.tests.dao;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurDaoTest {
	
public static void main(String[] args) {
		
		Visiteur Patrick = new Visiteur ("01","Pat","Patrick","Patrick001","Patoche","1 rue des oliviers","0297025658","25-02-1958");
		
		VisiteurDao.creer(Patrick);
		Patrick = new Visiteur ("01","Pat","Patrick","Patrick001","Patoche","1 rue des oliviers","0297025658","25-02-1958");
		VisiteurDao.modifier(Patrick);
		VisiteurDao.supprimer(Patrick.getMatricule());
	}
}
