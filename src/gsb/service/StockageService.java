package gsb.service;

import gsb.modele.Stockage;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockageDao;
import gsb.modele.dao.VisiteDao;

public class StockageService {
	
	 public static Stockage rechercherStockage(String depotlegal){
		  Stockage unStockage = null;
		  try{
		  if (unStockage == null) {
		            throw new Exception("Donnée obligatoire : code");
		        }
		  unStockage = StockageDao.rechercher(depotlegal);
		  }
		  catch(Exception e){
		   System.out.println( e.getMessage());
		  }
		  return unStockage;
		 }
	 
	 public static int creerStockage(Stockage unStockage){
			int result = 0;
			try{
				if(unStockage.getQte() == null || unStockage.getLeVisiteur() == null || unStockage.getLeMedicament() == null){
					throw new Exception("Donnée obligatoire : Quantité, Matricule, DepotLegal");
				}
				if(VisiteDao.rechercher(unStockage.getLeMedicament().getDepotLegal()) != null){
					throw new Exception("Une visite avec le code" + unStockage.getLeMedicament().getDepotLegal() +" existe déjà");
				}
				result = StockageDao.creer(unStockage);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			return result;
		}
	 
	 public int supprimerStockage(String unDepotLegal){
			int result = 0;
			try{
				if(unDepotLegal == null){
					throw new Exception("Donnée obligatoire : DepotLegal");
				}
				if(StockageDao.rechercher(unDepotLegal) == null){
					throw new Exception("La visite avec le code" + unDepotLegal +" n'existe pas");
				}
			result =StockageDao.supprimer(unDepotLegal);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			return result;
		}
	 
}










