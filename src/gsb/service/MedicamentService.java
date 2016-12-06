package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	
	 public static Medicament rechercherMedicament(String unDepotLegal){
		  Medicament unMedicament = null;
		  try{
		  if (unDepotLegal==null) {
		            throw new Exception("Donnée obligatoire : depot legal");
		        }
		  unMedicament = MedicamentDao.rechercher(unDepotLegal);
		  }
		  catch(Exception e){
		   System.out.println(e.getMessage());
		  }
		  return unMedicament;
		 }
	 
	 public int creerMedicament(Medicament unMedicament){
			int result = 0;
			
			try{
				if(unMedicament.getDepotLegal() == null || unMedicament.getNomCommercial() == null || unMedicament.getComposition() == null || unMedicament.getEffets() == null || 
				   unMedicament.getContreIndication() == null || unMedicament.getPrixEchantillon() == null || unMedicament.getCodeFamille() == null || unMedicament.getLibelleFamille() == null){
					throw new Exception("Donnée obligatoire : depotLegal, nomCommercial, composition, effets, contreIndication, prixEchantillion, uneFamille");
				}
				if(MedicamentDao.rechercher(unMedicament.getDepotLegal()) != null){
					throw new Exception("Une visite avec le code" + unMedicament.getDepotLegal() +" existe déjà");
				}
				result = MedicamentDao.creer(unMedicament);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			return result;
		}
				
		
		public int supprimerMedicament(String unDepotLegal){
			int result = 0;
			try{
				if(unDepotLegal == null){
					throw new Exception("Donnée obligatoire : Reference");
				}
				if(MedicamentDao.rechercher(unDepotLegal) == null){
					throw new Exception("La visite avec le code" + unDepotLegal +" n'existe pas");
				}
			result = MedicamentDao.supprimer(unDepotLegal);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			return result;
		}
			
		
		public int modifierMedicament(Medicament unMedicament){
			int result = 0;
			
			try{
				if(unMedicament.getDepotLegal() == null || unMedicament.getNomCommercial() == null || unMedicament.getComposition() == null || unMedicament.getEffets() == null ||
				   unMedicament.getContreIndication() == null || unMedicament.getPrixEchantillon() == null || unMedicament.getCodeFamille() == null || unMedicament.getLibelleFamille() == null){
					throw new Exception("Donnée obligatoire : depotLegal, nomCommercial, composition, effets, contreIndication, prixEchantillion, uneFamille");
				}
				if(MedicamentDao.rechercher(unMedicament.getDepotLegal()) == null){
					throw new Exception("La famille avec le code" + unMedicament.getDepotLegal() +" n'existe pas");
				}
			result = MedicamentDao.modifier(unMedicament);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		return result;
		}
	}