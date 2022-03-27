package classesMetiers;

import java.util.Date;

public class Mecanicien extends Personnel {
	
	private String qualification;
	private Date dateQualification;
	private Voiture uneVoiture;
	
	//Le constructeur
	public Mecanicien(String nom, String prenom, String adresse, String ville, String cp, Ecurie unEcurie,
			String qualification, Date dateQualification, Voiture uneVoiture) {
		super(nom, prenom, adresse, ville, cp, unEcurie);
		this.qualification = qualification;
		this.dateQualification = dateQualification;
		this.uneVoiture = uneVoiture;
	}
	
	//Les getteurs
	public String getQualification() {
		return qualification;
	}

	public Date getDateQualification() {
		return dateQualification;
	}

	public Voiture getUneVoiture() {
		return uneVoiture;
	}


}
