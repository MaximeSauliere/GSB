package gsb.modele;

public class Offre {
	
	protected int qteOfferte;
	protected Medicament unMedicament;
	protected Visite uneVisite;
	
	public Offre(int qteOfferte, Medicament unMedicament, Visite uneVisite) {
		super();
		this.qteOfferte = qteOfferte;
		this.unMedicament = unMedicament;
		this.uneVisite = uneVisite;
	}

	public int getQteOfferte() {
		return qteOfferte;
	}

	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}

	public Medicament getUnMedicament() {
		return unMedicament;
	}

	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	public Visite getUneVisite() {
		return uneVisite;
	}

	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}
	
	

}
