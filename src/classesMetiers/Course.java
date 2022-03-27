package classesMetiers;

import java.util.ArrayList;
import java.util.Date;

public class Course {
	//Attributs d'instance
	private String nom;
	private String typeCourse;
	private int nbrSpectateurs;
	private Circuit unCircuit;
	private int idCircuit;
	private ArrayList<Spectateur> lesSpectateurs;
	private ArrayList<Ecurie> lesEcuries;
	ModelDB db = new ModelDB();
	
	

	//Constructeur
	public Course(String nom, String typeCourse, int nbrSpectateurs, int idCircuit) {
		this.nom = nom;
		this.typeCourse = typeCourse;
		this.nbrSpectateurs = nbrSpectateurs;
		this.idCircuit = idCircuit;
		this.lesSpectateurs = new ArrayList<Spectateur>();;
		this.lesEcuries = new ArrayList<Ecurie>();
		
	}
	
	
	//Les accesseurs des attributs d'instance
	public String getNom() {
		return nom;
	}


	public String getTypeCourse() {
		return typeCourse;
	}


	public int getNbrSpectateurs() {
		return nbrSpectateurs;
	}

	public Circuit getUnCircuit() {
		return this.unCircuit;
	}


	public void setUnCircuit(Circuit unCircuit) {
		this.unCircuit = db.recupCircuit(this.idCircuit);
	}
	
	public int getIdCircuit() {
		return idCircuit;
	}

	
	//Les accesseurs des de la collection de sp�cateurs
	
	

	//La taille 
	public int nombreSpectateurs() {
		if(this.lesSpectateurs.size() != 0) {
			this.nbrSpectateurs = lesSpectateurs.size();
		}
		return nbrSpectateurs;
	}
	
	//Ajouter un sp�ctateur
	public boolean ajouterSpectateur(Spectateur unSpectateur) {
		boolean verification = false;
		//v�rifier si le sp�ctateur existe d�ja dans la collection
		if(!this.lesSpectateurs.contains(unSpectateur)) {
			this.lesSpectateurs.add(unSpectateur);
			verification = true;
		}
		
		return verification;
	}
	
	//Surcharge ajouter un sp�ctateur
	public boolean ajouterSpectateur(String unNom, String unPrenom, int unAge) {
		boolean verification = false;
		//v�rifier si le sp�ctateur existe d�ja dans la collection
		
		if(!this.lesSpectateurs.contains(new Spectateur(unNom, unPrenom,unAge))) {
			this.lesSpectateurs.add(new Spectateur(unNom, unPrenom,unAge));
			verification = true;
		}
		
		return verification;
	}
	
	
	//supprimer un sp�ctateur
	public boolean supprimerSpectateur(Spectateur unSpectateur) {
		boolean verification = false;
		
		//v�rifier si l'utilisateur existe
		if(!this.lesSpectateurs.contains(unSpectateur)) {
			this.lesSpectateurs.remove(unSpectateur);
			verification = true;
		}
		return verification;
	}
	
	
	//Supprimer � partir d'un nom du sp�ctateur
	public boolean supprimerSpectateur(String unNom) {
		boolean verification = false;
		//v�rififier si l'utilisateur existe dans la colelction et r�cup�rer son index
		
		int index = rechercheSpectateur(unNom);
		
		if(index != 0) {
			this.lesSpectateurs.remove(index);
			verification = true;
		}
		
		return verification;
		
	}

	
	//Recherche 
	public int rechercheSpectateur(String unNom) {
		int index = 0;
		int i = 0;
		
		while(i < this.lesSpectateurs.size() && !this.lesSpectateurs.get(i).getNom().equals(unNom)) {
			i++;
		}
		
		if(i < this.lesSpectateurs.size()) {
			index = i;
		}
		
		return index;
	}
	
	//Surcharge Recherche renvoie un Spectateur
	public Spectateur rechercheSpectateurA(String unNom){
		Spectateur unSpectateur = null;
	
		int i = 0;
		
		while(i < this.lesSpectateurs.size() && !this.lesSpectateurs.get(i).getNom().equals(unNom)) {
			i++;
		}
		
		if(i < this.lesSpectateurs.size()) {
			unSpectateur = this.lesSpectateurs.get(i);
		}
		
		return unSpectateur;
		
	}
	
	
	//Ajouter un �curie
	public boolean ajouterEcurie(Ecurie unEcurie) {
		boolean ver = false;
		
		if(!this.lesEcuries.contains(unEcurie)) {
			this.lesEcuries.add(unEcurie);
			ver = true;
		}
		
		return ver;
		
	}
	
	//M�thode toXml
	public String toXml() {
		String course = "\t <course> \n";
		
		course += "\t \t <nom_course>" + this.nom + "</nom_course> \n";
		course += "\t \t  <type_course>" + this.typeCourse + "</type_course> \n";
		course += "\t \t <nombre_spectateur>" + this.nbrSpectateurs + "</nombre_spectateur> \n";
		
		if(this.unCircuit != null) {
			course += "\t <circuit>" + this.getUnCircuit().toXML()+ "</circuit> \n";
		}
		
		if (lesSpectateurs.size() != 0) {
			for(Spectateur unSpectateur : lesSpectateurs) {
				course += "\t <spectateurs>" + unSpectateur.toXML() + "</spectateurs> \n";
				
			}
		}
		
		if (lesEcuries.size() != 0) {
			for(Ecurie uneEcurie : lesEcuries) {
				course += "\t <Ecuries>" + uneEcurie.toXML() + "</Ecuries> \n";
			}
		}

		
		course += "\t </course>";
		
		
		return course;
		
	}
	
}
