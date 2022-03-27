package classesMetiers;

public class Pilote extends Personnel {
	private int numeroPilote;
	private String nationalite;
	private Voiture uneVoiture;
	
	
	//Constructeur
	public Pilote(String nom, String prenom, String adresse, String ville, String cp, Ecurie unEcurie, int numeroPilote,
			String matricule, Voiture uneVoiture) {
		super(nom, prenom, adresse, ville, cp, unEcurie);
		this.numeroPilote = numeroPilote;
		this.nationalite = matricule;
		this.uneVoiture = uneVoiture;
	}


	//Les getteurs
	public int getNumeroPilote() {
		return numeroPilote;
	}


	public String getMatricule() {
		return nationalite;
	}
	
	public Voiture getUneVoiture() {
		return uneVoiture;
	}
	
}
