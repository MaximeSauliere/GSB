package gsb.service;

import gsb.modele.Offre;
import gsb.modele.dao.OffreDao;

public class OffreService {
	
	 public static Offre rechercherOffre(int qteOfferte){
		  Offre uneOffre = null;
		  try{
		  if (uneOffre==null) {
		            throw new Exception("Donnée obligatoire : quantite offerte");
		        }
		  uneOffre = OffreDao.rechercher(qteOfferte);
		  }
		  catch(Exception e){
		   System.out.println( e.getMessage());
		  }
		  return uneOffre;
		 }

}
