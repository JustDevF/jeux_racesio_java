package classesMetiers;

public class Voiture {
	private String marque;
	private String modele;
	private int nbCheveaux;
	
	//Le constructeur
	public Voiture(String marque, String modele, int nbCheveaux) {
		this.marque = marque;
		this.modele = modele;
		this.nbCheveaux = nbCheveaux;
	}
	
	//les getteurs
	public String getMarque() {
		return marque;
	}

	public String getModele() {
		return modele;
	}

	public int getNbCheveaux() {
		return nbCheveaux;
	}


	
}
