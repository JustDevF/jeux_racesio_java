package classesMetiers;

import java.util.ArrayList;

public class Ecurie {
	private String nom;
	private String sponsor;
	private String motoriste;
	private int idCourse;
	private ArrayList<Personnel> lesPersonnels;
	
	//Les constructeur
	public Ecurie(String nom, String sponsort, String motoriste, int idCourse) {
		super();
		this.nom = nom;
		this.sponsor = sponsort;
		this.motoriste = motoriste;
		this.idCourse = idCourse;
		this.lesPersonnels = new ArrayList<Personnel>();
	}

	public String getNom() {
		return nom;
	}

	public String getSponsort() {
		return sponsor;
	}

	public String getMotoriste() {
		return motoriste;
	}
	
	
	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	//M�thode d'instance
	public boolean ajouterPersonnel(Personnel unPersonnel) {
		boolean ver = false;
		
		//v�rifier si le personell existe d�ja
		if (!this.lesPersonnels.contains(unPersonnel)) {
			this.lesPersonnels.add(unPersonnel);
			ver = true;
		}
		return ver;
	}

	public ArrayList<Personnel> getLesPersonnels() {
		return lesPersonnels;
	}

	//Méthode toXML
	public String toXML() {
		String ecurie = "<ecurie> \n";
		
		ecurie += "\t <nom_ecurie>" + this.nom + "</nom_ecurie> \n";
		ecurie += "\t <sponsor_ecurie>" + this.sponsor + "</sponsor_ecurie> \n";
		ecurie += "\t <motoriste_ecurie>" + this.motoriste + "</motoriste_ecurie> \n";
		
		ecurie += "</ecurie>";
		return ecurie;
	}
	
	


}
