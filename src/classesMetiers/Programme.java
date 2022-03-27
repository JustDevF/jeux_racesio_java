package classesMetiers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Programme {

	public static void main(String[] args) {
		
		//Instancier un Spectateur
		
		//Spectateur unSpectateur = new Spectateur("katasi", "Justin", 20);
		//Spectateur uneSpectatrice = new Spectateur("Planche", "Cathy", 20);
		
		//instancier un circuit
		//Circuit unCircuit = new Circuit("RayPlay", 500, "France", 2);
		//Circuit uCircuit = new Circuit("Bunch", 400, "Belgique", 1);
		
		//instancier une course
		//cr�er une date;
		//String date = "10-Oct-2020";
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		//Date uneDate = new Date();
		
		/*
		try {
		    uneDate = formatter.parse(date);
		    formatter.format(date);
		} catch (ParseException e) {
		    System.out.println("Erreur de date");
		}
		*/
		
		//Course uneCourse = new Course("voiture", "Rally", 20, uneDate, unCircuit);
		//Course uneAutreCourse = new Course("Moto", "race", 30, uneDate, uCircuit);
		
		//Ajouter les spactateur
		//uneCourse.ajouterSpectateur(unSpectateur);
		//uneAutreCourse.ajouterSpectateur(uneSpectatrice);
		
		//instancier les Ecuries
		

		//Ajouter les spactateur
		//Ecurie unEcurie = new Ecurie("DrayBool", "orange", "pirate");
		
		//Ajouter des personnels de l'�curie
		//instancier des personnels 
		//instancier une voiture
		//Voiture uneVoiture = new Voiture("Peugeot", "5008", 500);
		//Pilote unPilote = new Pilote("Deleor", "Jean", "20 rue de la breux", "fleury", "91701", unEcurie, 4570, "TZ40X", uneVoiture);
		
		//unEcurie.ajouterPersonnel(unPilote);
		
		//Ajouter l'�curie � la course
		//uneCourse.ajouterEcurie(unEcurie);
		
			
		//System.out.println(uneCourse.toXml());
		
		//Ajouter un spectateur dans la liste de collection

		
		ModelDB db = new ModelDB();
		
		
		//boolean ver = db.ConnexionUtilisateur("Katasi", "kA1@aa");
		//boolean verCircuit = db.ajouterCircuit("Son of anarchy", 600, "belgique");
		
		//boolean verCourse = db.ajouterCourse("Start-up", "cyberRace", 4000, 3);
		
		//Circuit leCircuit = db.recupCircuit(3); /** faire un test junit*/
		
		ArrayList<Course> listeCourse = db.recupCourses();
		
		System.out.println(listeCourse.get(1).toXml());
		
		
		
		//boolean verSpectateur = db.ajouterSpectateur("Dieu", "Katasi", 2);
		/*
		ArrayList<Spectateur> listSpectateurs = db.recupSpectateur();
		
		for(Spectateur unSpectateur: listSpectateurs) {
			System.out.println(unSpectateur.toXML());
			
		}
		*/
		//boolean verEcurie = db.ajouterEcurie("vla", "free", "rien", 2);
		//System.out.println(verEcurie);
		
		/*
		ArrayList<Ecurie> listEcurie = db.recupEcurie();
		
		for(Ecurie uneEcurie: listEcurie) {
			System.out.println(uneEcurie.toXML());
			
		}
		*/
		
		
		
		
	}

}
