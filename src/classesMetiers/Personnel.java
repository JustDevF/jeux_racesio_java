package classesMetiers;

public abstract class Personnel {
	//Attributs d'instance
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String cp;
	private Ecurie unEcurie;
	
	public Personnel(String nom, String prenom, String adresse, String ville, String cp, Ecurie unEcurie) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.unEcurie = unEcurie;
		this.unEcurie.ajouterPersonnel(this);
	}
	

	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}


	public String getVille() {
		return ville;
	}

	public String getCp() {
		return cp;
	}


	public Ecurie getUnEcurie() {
		return unEcurie;
	}


	
}
