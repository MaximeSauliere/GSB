package gsb.service;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;

public class VisiteService {
	
	public static Visite rechercherVisite(String uneReference){
		Visite uneVisite = null;
		try{
		if (uneReference == null) {
            throw new Exception("Donnée obligatoire : reference");
        }
		uneVisite = VisiteDao.rechercher(uneReference);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneVisite;
	}
	
	public int creerVisite(String uneReference, String uneDate, String unCommentaire, Visiteur unVisiteur, Medecin unMedecin){
		Visite uneVisite;
		int result = 0;
		try{
			if(uneReference == null || uneDate == null || unCommentaire == null || unVisiteur == null || unMedecin == null){
				throw new Exception("Donnée obligatoire : uneReference, uneDate, unCommentaire, unVisiteur, unMedecin");
			}
			if(!ValidationUtils.isDateValide(uneDate)){
				throw new Exception ("le numero de téléphone n'est pas valide");
			}
			if(VisiteDao.rechercher(uneReference) != null){
				throw new Exception("Une visite avec le code" + uneReference +" existe déjà");
			}
			uneVisite = new Visite(uneReference, uneDate, unCommentaire, unVisiteur, unMedecin);
			result = VisiteDao.creer(uneVisite);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}
			
	
	public int supprimerVisite(String uneReference){
		int result = 0;
		try{
			if(uneReference == null){
				throw new Exception("Donnée obligatoire : Reference");
			}
			if(VisiteDao.rechercher(uneReference) == null){
				throw new Exception("La visite avec le code" + uneReference +" n'existe pas");
			}
		result = VisiteDao.supprimer(uneReference);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}
		
	
	public int modifierFamille(String uneReference, String uneDate, String unCommentaire, Visiteur unVisiteur, Medecin unMedecin){
		Visite uneVisite;
		int result = 0;
		try{
			if(uneReference == null || uneDate == null || unCommentaire == null || unVisiteur == null || unMedecin == null){
				throw new Exception("Donnée obligatoire : CodeFamille, libelleFamille");
			}
			if(!ValidationUtils.isDateValide(uneDate)){
				throw new Exception ("le numero de téléphone n'est pas valide");
			}
			if(VisiteDao.rechercher(uneReference) == null){
				throw new Exception("La famille avec le code" + uneReference +" n'existe pas");
			}
		uneVisite = new Visite(uneReference, uneDate, unCommentaire, unVisiteur, unMedecin);
		result = VisiteDao.modifier(uneVisite);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	return result;
	}
}
