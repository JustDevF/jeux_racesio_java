package classesMetiers;

import java.sql.*;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class ModelDB {
	//Attributs priv�es statiques de la classe
	private static Connection connexion = null;
	private static PreparedStatement statement = null;
	private static ResultSet rs = null;
	
	
	//Attributs priv�es d'instance
	private String urlDbase ="jdbc:mysql://localhost:3306/racesio?serverTimezone=UTC";
    private String user = "root";
    private String password = "123456";
  
    //Les constructeur
	public ModelDB() {
		
		try {
			//Le chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Le connexion � la base de donn�es
			connexion = DriverManager.getConnection(this.urlDbase, this.user, this.password);
		} catch (ClassNotFoundException erreur) {
			//erreur de chargement de driver mysqlconnector
			System.out.println("Le driver n'a pas pu �tre charg�" + erreur.getStackTrace());
		} catch (SQLException erreur) {
			//erreur de connexion � la base de donn�es
			System.out.println("Probl�me de connexion : " + " " + erreur.getMessage());
		}
	}
	
	//Le d�constructeur
	//M�thode d'instance pour fermer la connexion
    public void fermerConnexion() {
		if (ModelDB.connexion != null ){
			try {
				ModelDB.connexion.close();
				ModelDB.connexion = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	}
    
    
    //Connexion utilisateur
    public boolean ConnexionUtilisateur(String unNom, String unMdp) {
    	boolean verifier = false;
    	int nbLigne;
  
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) from utilisateur where nom = ? and mdp = ?");
			statement.setString(1, unNom);
			statement.setString(2, unMdp);
			rs = statement.executeQuery();
			
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				if (nbLigne != 0)
					verifier = true;
			}
		} catch (SQLException e) {
			System.out.println("Connexion utilisateur échoué" + e.getMessage());
		}
		return verifier;
    	
    }
    
    /*********Les ajouts *************************/
    
    //1. Circuit 
   
    //ajout de circuit
    public boolean ajouterCircuit(String unNom, int uneTaille, String unPays ) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si le circuit n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Circuit where nom = ? and taille = ? and pays = ?");
			statement.setString(1, unNom);
			statement.setInt(2, uneTaille);
			statement.setString(3, unPays);
			
			
			rs = statement.executeQuery();
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout du circuit
						statement = connexion.prepareStatement("INSERT INTO Circuit(nom, taille, pays) VALUES(?, ?, ?)");
						statement.setString(1, unNom);
						statement.setInt(2, uneTaille);
						statement.setString(3, unPays);
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification du circuit existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    //Récupérer les informations des cricuits disponibles
    
    //Ecurie
    
    //2. Ajout  d'ecurie
    public boolean ajouterEcurie(String unNom, String unSponsor, String unMotoriste, int idCourse ) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si l'écurie n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Ecurie where nom = ? and idCourse = ?");
			statement.setString(1, unNom);
			statement.setInt(2, idCourse);
			
			
			rs = statement.executeQuery();
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout du circuit
						statement = connexion.prepareStatement("INSERT INTO Ecurie(nom, sponsor, motoriste, idCourse) VALUES(?, ?, ?, ?)");
						statement.setString(1, unNom);
						statement.setString(2, unSponsor);
						statement.setString(3, unMotoriste);
						statement.setInt(4, idCourse);
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    //Ecurie
    
    //3. Ajout de course
    public boolean ajouterCourse(String unNom, String unType, int nbrSpectateur, int idCircuit ) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si la course n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Course where nom = ? and type = ?");
			statement.setString(1, unNom);
			statement.setString(2, unType);
			
			
			rs = statement.executeQuery();
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout de la course
						statement = connexion.prepareStatement("INSERT INTO Course(nom, type, nbrSpectateur, idCircuit) VALUES(?, ?, ?, ?)");
						statement.setString(1, unNom);
						statement.setString(2, unType);
						statement.setInt(3, nbrSpectateur);
						statement.setInt(4, idCircuit);
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    //4. Ajout du personnel
    public boolean ajouterPersonnel(String unNom, String unPrenom, String uneAdresse, String uneVille, String unCp, int idEcurie ) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si le personnel  n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Personnel where nom = ? and idEcurie = ?");
			statement.setString(1, unNom);
			statement.setInt(2, idEcurie);
			
			
			rs = statement.executeQuery();
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout du personnel 
						statement = connexion.prepareStatement("INSERT INTO Personnel(nom, prenom, adresse, ville, cp, idEcurie) VALUES(?, ?, ?, ?, ?, ?)");
						statement.setString(1, unNom);
						statement.setString(2, unPrenom);
						statement.setString(3, uneAdresse);
						statement.setString(4, uneVille);
						statement.setString(5, unCp);
						statement.setInt(6, idEcurie);
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    //5. Ajout de mecanicien
    public boolean ajouterMecanicien(int idPersonnel, String uneQualification, String uneDateQualification) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si le personnel  n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Mecanicien where idPersonnel = ?");
			statement.setInt(1, idPersonnel);
			
			rs = statement.executeQuery();
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout du mecanicien(e)
						statement = connexion.prepareStatement("INSERT INTO Mecanicien VALUES(?, ?, ?)");
						statement.setInt(1, idPersonnel);
						statement.setString(2, uneQualification);
						statement.setString(3, uneDateQualification);
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    //6. Ajout de pilote
    public boolean ajouterPilote(int idPersonnel, String uneQualification, String uneDateQualification) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si le personnel  n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Mecanicien where idPersonnel = ?");
			statement.setInt(1, idPersonnel);
			
			rs = statement.executeQuery();
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout du mecanicien(e)
						statement = connexion.prepareStatement("INSERT INTO Mecanicien VALUES(?, ?, ?)");
						statement.setInt(1, idPersonnel);
						statement.setString(2, uneQualification);
						statement.setString(3, uneDateQualification);
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    //7. Ajout de voiture
    public boolean ajouterVoiture(String  marque, String modele, int nbCheveaux, int idMecanicien, int idPilote) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si la voiture  n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Voiture where idMecanicien = ? and idPilote = ?");
			statement.setInt(1, idMecanicien);
			statement.setInt(2, idPilote);
			
			rs = statement.executeQuery();
			
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout une voiture
						statement = connexion.prepareStatement("INSERT INTO Voiture(marque,modele,nbCheveaux,idMecanicien,idPilote) VALUES(?, ?, ?, ?, ?)");
						statement.setString(1, marque);
						statement.setString(2, modele);
						statement.setInt(3, nbCheveaux);
						statement.setInt(4, idMecanicien);
						statement.setInt(5, idPilote);
						
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    //8. Ajout de Spectateur
    public boolean ajouterSpectateur(String  nom, String prenom, int idCourse) {
    	boolean verif = false;
    	int nbLigne;
    	int LignInserees;
    	//Vérifier si la voiture  n'existe pas dans la base de données
    	try {
			statement = connexion.prepareStatement("SELECT COUNT(*) FROM Spectacteur where idCourse = ?");
			statement.setInt(1, idCourse);
	
			
			rs = statement.executeQuery();
			
			//obtention d'une ligne 
			if(rs.next()) {
				nbLigne = rs.getInt(1);
				
				//on vérifie si la requête renvoie 1 ou 0 
				if (nbLigne == 0)
					try {
						//requête d'ajout une voiture
						statement = connexion.prepareStatement("INSERT INTO Spectacteur(nom,prenom,idCourse) VALUES(?, ?, ?)");
						statement.setString(1, nom);
						statement.setString(2, prenom);
						statement.setInt(3, idCourse);
						
						LignInserees = statement.executeUpdate();
						
						if(LignInserees != 0) {
							verif = true;
						}	
					} catch(SQLException e) {
						System.out.print("Insértion échouée" + "" + e.getMessage());
					}
							
			}
		} catch (SQLException e) {
			System.out.print("Vérification de l'écurie existant échouée" + "" + e.getMessage());
		}
    	
    	return verif;
    }
    
    
    
    
    
    /***********La récupérations des données ********/
    
    //1. récup les courses dans une collection course
    public ArrayList<Course> recupCourses(){
		//déclarer et instancier la collection
    	ArrayList<Course> listCourse = new ArrayList<Course>();
    	String nom;
    	String type;
    	int idCircuit;
    	int nbrSpectateur;
    	
    	
		try {
			statement = connexion.prepareStatement("SELECT * FROM Course");
			rs = statement.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					nom = rs.getString("nom"); 
					type = rs.getString("type");
					nbrSpectateur =  rs.getInt("nbrSpectateur");
					idCircuit = rs.getInt("idCircuit");
				
					//ajouter des enrégistrements dans la collection de course
					listCourse.add(new Course(nom, type, nbrSpectateur, idCircuit));	
				}
				//rs.close(); 
				
			}
			
		} catch (SQLException erreur) {
			System.out.println("Problème de récupération des données : " + erreur.getMessage());
		}
		
		return listCourse;
  
    }
    
    //2. récup circuit
    public Circuit recupCircuit(int idCircuit){
    	Circuit leCircuit = null;
    	String nom;
    	Double taille;
    	String pays;
    	 	
		try {
			statement = connexion.prepareStatement("SELECT * FROM Circuit WHERE idCircuit = ?");
			statement.setInt(1, idCircuit);
			rs = statement.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					nom = rs.getString("nom"); 
					taille = rs.getDouble("taille");
					pays = rs.getString("pays");
					
					//ajouter un circuit
					leCircuit = new Circuit(nom, taille, pays);
				}
				//rs.close();
				
			}
			
		} catch (SQLException erreur) {
			System.out.println("Problème de récupération des données : " + erreur.getMessage());
		}
		
		return leCircuit;
  
    }
    
    //3. récup spectateur
    public ArrayList<Spectateur> recupSpectateur(){
		//déclarer et instancier la collection
    	ArrayList<Spectateur> listSpectateur = new ArrayList<Spectateur>();
    	String nom;
    	String prenom;
    	int idCourse;
    	  	
		try {
			statement = connexion.prepareStatement("SELECT * FROM Spectacteur");
			rs = statement.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					nom = rs.getString("nom"); 
					prenom = rs.getString("prenom");
					idCourse =  rs.getInt("idCourse");
		
					listSpectateur.add(new Spectateur(nom, prenom, idCourse));	
				}
				//rs.close(); 
				
			}
			
		} catch (SQLException erreur) {
			System.out.println("Problème de récupération des données : " + erreur.getMessage());
		}
		
		return listSpectateur;
  
    }
    
    //4. récup écurie
    public ArrayList<Ecurie> recupEcurie(){
		//déclarer et instancier la collection
    	ArrayList<Ecurie> listEcurie = new ArrayList<Ecurie>();
    	String nom;
    	String sponsor;
    	String motoriste;
    	int idCourse;
    	  	
		try {
			statement = connexion.prepareStatement("SELECT * FROM Ecurie");
			rs = statement.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					nom = rs.getString("nom"); 
					sponsor = rs.getString("sponsor");
					motoriste = rs.getString("motoriste");
					idCourse =  rs.getInt("idCourse");
		
					listEcurie.add(new Ecurie(nom, sponsor, motoriste, idCourse));	
				}
				//rs.close(); 
				
			}
			
		} catch (SQLException erreur) {
			System.out.println("Problème de récupération des données : " + erreur.getMessage());
		}
		
		return listEcurie;
  
    }
    
    
    
}

