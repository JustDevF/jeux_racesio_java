package classesMetiers;

public class Spectateur {
	//Attributs de la classe
	private String nom;
	private String prenom;
	private int age;
	
	public Spectateur(String unNom, String unPrenom, int unAge) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.age = unAge;
	}

	//Les acceseurs
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}
	
	public String toXML() {
		String spectateur = "\t <spectateur> \n";
		
			spectateur += "\t \t<nom_spectateur>" + this.nom + "</ nom_spectateur> \n";
			spectateur += "\t \t <prenom_spectateur>" + this.prenom + "</ prenom_spectateur> \n";
			spectateur += "\t \t <age_spectateur>" + this.age + "</ age_spectateur> \n";
	
		spectateur += "\t </spectateur>";
		return spectateur;
	}
	
	
	
}

