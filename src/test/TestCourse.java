package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classesMetiers.Course;
import classesMetiers.ModelDB;



/**
 * @author jkatasi
 *
 */
class ModelDBTest {
	//M�tode d'instance
	private ModelDB db; 
	
	@BeforeEach
	void setUp() throws Exception {
		db = new ModelDB();
	}

	/*
	*Option 1
	@Test
	void testPersonne() {
		if (! p.getLogin().equals("lmartin"))
			fail ("Pas de majuscules !!");
	}
	*/
	
	//Option 2
	@Test
	void testConnexion() {
		//Utilisation d'une méthode statique de la classe Assert
		//la fonction connexion doit tjrs renvoyer une booléen 
		
		System.out.println();
		
		boolean ver = db.ConnexionUtilisateur("katasi", "kA1@aa");
		
		if (ver != true && ver != false) {
			System.out.println("Format non entendu");
		}
		
	}
	
	
	/*
	@Test
	void testGetLogin() {
		fail("Not yet implemented");
	}

	*/
	
	@Test
	void testAjoutCourse() {
		String modele = "	 <course> \r\n"
				+ "	 	 <nom_course>Carlos</nom_course> \r\n"
				+ "	 	  <type_course>Course_moto</type_course> \r\n"
				+ "	 	 <nombre_spectateur>8000</nombre_spectateur> \r\n"
				+ "	 </course>";
		
		ArrayList<Course> listeCourse = db.recupCourses();
		
		Assert.assertEquals("Erreur les deux chaînes ne correspondent pas", modele, listeCourse.get(1).toXml());
		
	 	 

	}
	
	
}
