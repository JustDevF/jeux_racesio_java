//Répetoire de la classe
package classesFenetres;
//Importer les des éléments externes
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panelCircuit.PAjouterCircuit;
import panelCourse.PAfficherCourses;
import panelCourse.PAjouterCourse;
import panelEcurie.PAjouterEcurie;
import panelPersonnel.PAjouterMecanicien;
import panelPersonnel.PAjouterPilote;
import panelSpectateur.PAjouterSpectateur;
import panelVoiture.PAjouterVoiture;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

//Classe Fenêtre
public class FMenu extends JFrame {
	//id défaut
	private static final long serialVersionUID = 1L;
	//Attribut d'instance
	private JPanel contentPane;
	private final Action actionAjouterCourse = new ActionAjouterCourse();
	private final Action actionAjouterEcuries = new ActionAjouterEcurie();
	private final Action actionGestionProprietaire = new ActionAjouterProprietaire();
	private final Action actionAjouterCircuit = new ActionAjouterCircuit();
	private final Action actionAJouterPIlote = new ActionAjouterPilote();
	private final Action actionAjouterMecanicien = new ActionAjouterMecanicien();
	private final Action actionAJouterSpectateur = new ActionAjouterSpectateur();
	private final Action actionAjouterVoiture = new ActionAjouterVoiture();
	private final Action actionAfficheCourse = new ActionAfficherCourse();

	//lanceur de l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMenu frame = new FMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructeur
	 */
	public FMenu() {
		//Les pripriétés de la fenêtre
		setIconImage(Toolkit.getDefaultToolkit().getImage(FMenu.class.getResource("/images/Data-Network-128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 499);
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuGesionCourses = new JMenu("Courses");
		menuBar.add(menuGesionCourses);
		
		JMenuItem sousMenuGesionCoursesAJouter = new JMenuItem("Ajouter une course");
		sousMenuGesionCoursesAJouter.setAction(actionAjouterCourse);
		menuGesionCourses.add(sousMenuGesionCoursesAJouter);
		
		JSeparator separator = new JSeparator();
		menuGesionCourses.add(separator);
		
		JMenuItem sousMenuGesionCoursesAfficher = new JMenuItem("Afficher les courses");
		sousMenuGesionCoursesAfficher.setAction(actionAfficheCourse);
		menuGesionCourses.add(sousMenuGesionCoursesAfficher);
		
		JSeparator separator_1 = new JSeparator();
		menuGesionCourses.add(separator_1);
		
		JMenuItem sousMenuGesionCoursesRechercher = new JMenuItem("REchercher une course");
		menuGesionCourses.add(sousMenuGesionCoursesRechercher);
		
		JSeparator separator_2 = new JSeparator();
		menuGesionCourses.add(separator_2);
		
		JMenuItem sousMenuGesionCoursesSupprimer = new JMenuItem("Supprimer une course");
		menuGesionCourses.add(sousMenuGesionCoursesSupprimer);
		
		JMenu menuGesionEcuries = new JMenu("Ecuries");
		menuBar.add(menuGesionEcuries);
		
		JMenuItem sousMenuGesionEcuriesAJouter = new JMenuItem("Ajouter une \u00E9curie");
		sousMenuGesionEcuriesAJouter.setAction(actionAjouterEcuries);
		menuGesionEcuries.add(sousMenuGesionEcuriesAJouter);
		
		JSeparator separator_3 = new JSeparator();
		menuGesionEcuries.add(separator_3);
		
		JMenuItem sousMenuGesionEcuriesAfficher = new JMenuItem("Afficher une \u00E9curie");
		menuGesionEcuries.add(sousMenuGesionEcuriesAfficher);
		
		JSeparator separator_4 = new JSeparator();
		menuGesionEcuries.add(separator_4);
		
		JMenuItem sousMenuGesionEcuriesRechercher = new JMenuItem("Rechercher une \u00E9curie");
		menuGesionEcuries.add(sousMenuGesionEcuriesRechercher);
		
		JSeparator separator_5 = new JSeparator();
		menuGesionEcuries.add(separator_5);
		
		JMenuItem sousMenuGesionEcuriesSupprimer = new JMenuItem("Supprimer une \u00E9curie");
		menuGesionEcuries.add(sousMenuGesionEcuriesSupprimer);
		
		JMenu menuGestionCircuit = new JMenu("Circuit");
		menuBar.add(menuGestionCircuit);
		
		JMenuItem sousMenuGesionCircuitAjouter = new JMenuItem("Ajouter un circuit");
		sousMenuGesionCircuitAjouter.setAction(actionAjouterCircuit);
		menuGestionCircuit.add(sousMenuGesionCircuitAjouter);
		
		JMenuItem sousMenuGesionCircuitSupprimer = new JMenuItem("Supprimer un circuit");
		menuGestionCircuit.add(sousMenuGesionCircuitSupprimer);
		
		JMenu menuGestionSpectateur = new JMenu("Sp\u00E9ctateur");
		menuBar.add(menuGestionSpectateur);
		
		JMenuItem sousMenuGestionSpectateurAjouter = new JMenuItem("Ajouter un sp\u00E9ctateur");
		sousMenuGestionSpectateurAjouter.setAction(actionAJouterSpectateur);
		menuGestionSpectateur.add(sousMenuGestionSpectateurAjouter);
		
		JMenuItem sousMenuGestionSpectateurSupprimer = new JMenuItem("Supprimer un sp\u00E9ctateur");
		menuGestionSpectateur.add(sousMenuGestionSpectateurSupprimer);
		
		JMenu menuGestionPersonnel = new JMenu("Personnel");
		menuBar.add(menuGestionPersonnel);
		
		JMenuItem sousMenuGestionPersonnelAJouterPilote = new JMenuItem("Ajouter un pilote");
		sousMenuGestionPersonnelAJouterPilote.setAction(actionAJouterPIlote);
		menuGestionPersonnel.add(sousMenuGestionPersonnelAJouterPilote);
		
		JMenuItem sousMenuGestionPersonnelAJouterMécanicien = new JMenuItem("Ajouter un m\u00E9canicien");
		sousMenuGestionPersonnelAJouterMécanicien.setAction(actionAjouterMecanicien);
		menuGestionPersonnel.add(sousMenuGestionPersonnelAJouterMécanicien);
		
		JMenuItem sousMenuGestionPersonnelRechercher = new JMenuItem("Recherche un personnel");
		menuGestionPersonnel.add(sousMenuGestionPersonnelRechercher);
		
		JMenuItem sousMenuGestionPersonnelSupprimer = new JMenuItem("Supprimer un personnel");
		menuGestionPersonnel.add(sousMenuGestionPersonnelSupprimer);
		
		JMenu menuGestionVoiture = new JMenu("Voiture");
		menuBar.add(menuGestionVoiture);
		
		JMenuItem sousMenuGestionVoitureAjouter = new JMenuItem("Ajouter une voiture");
		sousMenuGestionVoitureAjouter.setAction(actionAjouterVoiture);
		menuGestionVoiture.add(sousMenuGestionVoitureAjouter);
		
		JMenuItem sousMenuGestionVoitureSupprimer = new JMenuItem("Supprimer voiture");
		menuGestionVoiture.add(sousMenuGestionVoitureSupprimer);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	

    //Les actions
	private class ActionAjouterCourse extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterCourse() {
			putValue(NAME, "Ajouter course");
			putValue(SHORT_DESCRIPTION, "Ajouter une course");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterCourse pAjouterCourse = new PAjouterCourse();
			changerPanneau(pAjouterCourse, "AJouter une course");
			
		}
	}
	

    
	private class ActionAjouterEcurie extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterEcurie() {
			putValue(NAME, "Ajouter écurie");
			putValue(SHORT_DESCRIPTION, "Ajouter les écuries");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterEcurie pAjouterEcurie= new PAjouterEcurie();
			changerPanneau(pAjouterEcurie, "AJouter une écurie");
		}
	}
	

	private class ActionAjouterProprietaire extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterProprietaire() {
			putValue(NAME, "Ajouter propriétaire");
			putValue(SHORT_DESCRIPTION, "Ajouter les propriétaire");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterEcurie pAjouterEcurie= new PAjouterEcurie();
			changerPanneau(pAjouterEcurie, "AJouter une écurie");
		}
	}
	
	
	private class ActionAjouterCircuit extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterCircuit() {
			putValue(NAME, "Ajouter circuit");
			putValue(SHORT_DESCRIPTION, "Ajouter les circuits");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterCircuit pAjouterCircuit= new PAjouterCircuit();
			changerPanneau(pAjouterCircuit, "AJouter un circuit");
		}
	}
	

	private class ActionAjouterPilote extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterPilote() {
			putValue(NAME, "Ajouter Pilote");
			putValue(SHORT_DESCRIPTION, "Ajouter un pilote");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterPilote pAjouterPilote= new PAjouterPilote();
			changerPanneau(pAjouterPilote, "AJouter un circuit");
		}
	}
	
	
	private class ActionAjouterMecanicien extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionAjouterMecanicien() {
			putValue(NAME, "Ajouter mécanicien");
			putValue(SHORT_DESCRIPTION, "Ajouter un mécanicien");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterMecanicien pAjouterMecanicien= new PAjouterMecanicien();
			changerPanneau(pAjouterMecanicien, "AJouter un circuit");
		}
	}
	
	private class ActionAjouterSpectateur extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterSpectateur() {
			putValue(NAME, "Ajouter spectateur");
			putValue(SHORT_DESCRIPTION, "Ajouter un spéctateur");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterSpectateur pAjouterSpectateur= new PAjouterSpectateur();
			changerPanneau(pAjouterSpectateur, "AJouter un circuit");
		}
	}
	
	   
	private class ActionAjouterVoiture extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionAjouterVoiture() {
			putValue(NAME, "Ajouter voiture");
			putValue(SHORT_DESCRIPTION, "Ajouter une voiture");
		}
		public void actionPerformed(ActionEvent e) {
			//changerPanneau
			PAjouterVoiture pAjouterVoiture= new PAjouterVoiture();
			changerPanneau(pAjouterVoiture, "AJouter un circuit");
		}
	}
	
	 //Changer de panneau 
	  private void changerPanneau(JPanel panneau, String titre) { 
	     setContentPane(panneau); 
	     setTitle(titre); 
	     revalidate(); 
	 }
	private class ActionAfficherCourse extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ActionAfficherCourse() {
			putValue(NAME, "Afficher les courses");
			putValue(SHORT_DESCRIPTION, "Les course");
		}
		public void actionPerformed(ActionEvent e) {
			PAfficherCourses pAfficherCourse = new PAfficherCourses();
			changerPanneau(pAfficherCourse, "Afficher les course");
		}
	}
}
