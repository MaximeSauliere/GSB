package gsb.tests.dao;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;

public class VisiteDaoTest {
	
	public static void main(String[] args) {
		
		Visiteur Jean = new Visiteur ("02", "Dupont", "Jean", "DupontJ", "Jean56", " 1 rue de la rivière", "02-97-02-15-95", "2 Janvier 2016");
		Localite Lorient = new Localite ("56600","Lorient");
		Medecin Jack = new Medecin ("M01", "Dupont","Jack","1 rue foret",Lorient,"02-97-05-47-48",null,"Generaliste");
		Visite Premiere = new Visite ("V01","4 Novembre 2016",null,Jean,Jack);
		
		VisiteDao.creer(Premiere);
		Premiere = new Visite ("V01","4 Novembre 2016",null,Jean,Jack);
		VisiteDao.modifier(Premiere);
		VisiteDao.supprimer(Premiere.getReference());

		
	}

}
