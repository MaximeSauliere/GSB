package gsb.modele;

public class Visite {
	
	protected String reference;
	protected String date;
	protected String commentaire;
	protected Visiteur unVisiteur;
	protected Medecin unMedecin;
	
	public Visite(String reference, String date, String commentaire, Visiteur unVisiteur, Medecin unMedecin) {
		super();
		this.reference = reference;
		this.date = date;
		this.commentaire = commentaire;
		this.unVisiteur = unVisiteur;
		this.unMedecin = unMedecin;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	public Medecin getUnMedecin() {
		return unMedecin;
	}

	public void setUnMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}
	
	
	
	}
	