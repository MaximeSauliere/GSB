package gsb.modele;

public class Stockage {
	
	protected String quantite;
	protected Visiteur leVisiteur;
	protected Medicament leMedicament;
	
	public Stockage(String uneQte, Visiteur leVisiteur, Medicament leMedicament) {
		this.quantite = uneQte;
		this.leVisiteur = leVisiteur;
		this.leMedicament = leMedicament;
	}
	
	public String getQte() {
		return quantite;
	}

	public void setQte(String uneQte) {
		this.quantite = uneQte;
	}

	public Visiteur getLeVisiteur() {
		return leVisiteur;
	}

	public void setLeVisiteur(Visiteur leVisiteur) {
		this.leVisiteur = leVisiteur;
	}

	public Medicament getLeMedicament() {
		return leMedicament;
	}

	public void setLeMedicament(Medicament leMedicament) {
		this.leMedicament = leMedicament;
	}


}
