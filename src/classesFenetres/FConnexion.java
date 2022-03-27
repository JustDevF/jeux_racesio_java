package classesFenetres;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classesMetiers.ModelDB;

import java.awt.Toolkit;
import UI.UI;



//La fenêtre de connexion permettant d'acc�der � l'application
public class FConnexion extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	//Attributs d'instance
	private JTextField txtSaisieUtilisateur;
	private JPasswordField pwdMotDePasse;
	private JButton btnValider;
	
	
	private final Action actionValide = new ActionValider();
	private final Action actionQuitter= new ActionQuitter();
	private final Action actionEra = new ActionEra();

	
	
	//le lanceur de l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FConnexion frame = new FConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//le constructeur
	public FConnexion() {
		//appel de la m�thode pour afficher la fen�tre
		createContents();
		setBounds(500, 400, 700, 350);
	}
	
	
	//m�thode d'instance
	private void createContents() {
		//propri�t�s de la fen�tre de connexion
		setIconImage(Toolkit.getDefaultToolkit().getImage(FConnexion.class.getResource("/images/connection/Windows-8-Login-16.png")));
		setTitle("Gestion");
		
		
		
		//Affiche connexion au programme
		JLabel lblTitre = new JLabel("Connexion au programme");
		lblTitre.setFont(lblTitre.getFont().deriveFont(20f));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Shopping-Cart-05-48.png")));
		getContentPane().add(lblTitre, BorderLayout.NORTH);
		
		//Panneau global situ� au centre de la fen�tre
		JPanel panel_global = new JPanel();
		panel_global.setBorder(new CompoundBorder(new EmptyBorder(14, 14, 14, 14), new LineBorder(new Color(0x33, 0XB5, 0XE5), 3, true)));
		getContentPane().add(panel_global, BorderLayout.CENTER);
		panel_global.setLayout(new BorderLayout(0, 0));
		
		//Panneau de connexion situ�  dans le panneau global 
		JPanel panel_connexion = new JPanel();
		panel_connexion.setBackground(Color.WHITE);
		panel_connexion.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_global.add(panel_connexion);
		GridBagLayout gbl_panel_connexion = new GridBagLayout();
		gbl_panel_connexion.columnWidths = new int[] {134, 50, 0};
		gbl_panel_connexion.rowHeights = new int[]{26, 26, 66, 0};
		gbl_panel_connexion.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_connexion.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_connexion.setLayout(gbl_panel_connexion);
		
		//Champs identifiant
		JLabel lblUtilisateur = new JLabel("Identifiant");
		lblUtilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUtilisateur.setHorizontalTextPosition(SwingConstants.LEADING);
		lblUtilisateur.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Windows-8-Login-16.png")));
		GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
		gbc_lblUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUtilisateur.anchor = GridBagConstraints.LINE_END;
		gbc_lblUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilisateur.gridx = 0;
		gbc_lblUtilisateur.gridy = 0;
		panel_connexion.add(lblUtilisateur, gbc_lblUtilisateur);
		UI.habiller(lblUtilisateur);
		
		txtSaisieUtilisateur = new JTextField();
		GridBagConstraints gbc_txtSaisieUtilisateur = new GridBagConstraints();
		gbc_txtSaisieUtilisateur.weightx = 1.0;
		gbc_txtSaisieUtilisateur.anchor = GridBagConstraints.NORTH;
		gbc_txtSaisieUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSaisieUtilisateur.insets = new Insets(0, 0, 5, 0);
		gbc_txtSaisieUtilisateur.gridx = 1;
		gbc_txtSaisieUtilisateur.gridy = 0;
		panel_connexion.add(txtSaisieUtilisateur, gbc_txtSaisieUtilisateur);
		txtSaisieUtilisateur.setColumns(10);
		UI.habiller(txtSaisieUtilisateur);
		
		//Champs mot de passe
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMotDePasse.setHorizontalTextPosition(SwingConstants.LEADING);
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMotDePasse.anchor = GridBagConstraints.LINE_END;
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 1;
		panel_connexion.add(lblMotDePasse, gbc_lblMotDePasse);
		UI.habiller(lblMotDePasse);
		
		pwdMotDePasse = new JPasswordField();
		UI.habiller(pwdMotDePasse);
		GridBagConstraints gbc_pwdMotDePasse = new GridBagConstraints();
		gbc_pwdMotDePasse.weightx = 1.0;
		gbc_pwdMotDePasse.anchor = GridBagConstraints.NORTH;
		gbc_pwdMotDePasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdMotDePasse.insets = new Insets(0, 0, 5, 0);
		gbc_pwdMotDePasse.gridx = 1;
		gbc_pwdMotDePasse.gridy = 1;
		panel_connexion.add(pwdMotDePasse, gbc_pwdMotDePasse);
		
		JButton btnNewButton = new JButton("Era");
		btnNewButton.setAction(actionEra);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel_connexion.add(btnNewButton, gbc_btnNewButton);
		
		//Panneau qui contient les actions
		JPanel panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel_actions, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_actions = new GridBagLayout();
		gbl_panel_actions.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_actions.rowHeights = new int[]{0, 0, 0};
		gbl_panel_actions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_actions.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_actions.setLayout(gbl_panel_actions);
		
		
		//Bouton Cr�er un Quitter
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setAction(actionQuitter);
		btnQuitter.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Stop-48.png")));
		UI.deshabillerBouton(btnQuitter, "connection", "Stop");
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.gridwidth = 3;
		gbc_btnQuitter.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitter.gridx = 1;
		gbc_btnQuitter.gridy = 1;
		panel_actions.add(btnQuitter, gbc_btnQuitter);
		
		//Bouton valider
		btnValider = new JButton("Valider");
		btnValider.setAction(actionValide);
		btnValider.setHorizontalTextPosition(SwingConstants.LEADING);
		btnValider.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Power-48.png")));
		UI.deshabillerBouton(btnValider, "connection", "Power");
		btnValider.setOpaque(true);
		btnValider.setBackground(new Color(0x33, 0xB5, 0xE5));
		btnValider.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.gridx = 21;
		gbc_btnValider.gridy = 1;
		panel_actions.add(btnValider, gbc_btnValider);
		
		getRootPane().setDefaultButton(btnValider);
		pack();
		setSize(807, 287);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	//Les actions
	
	//Action de valider la connexion
	private class ActionValider extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionValider() {
			putValue(NAME, "Valider");
			putValue(SHORT_DESCRIPTION, "Se connecter � l'application");
		}
		public void actionPerformed(ActionEvent e) {
			valider();
		}
	}
	
	
	private class ActionQuitter extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ActionQuitter() {
			putValue(NAME, "Quitter");
			putValue(SHORT_DESCRIPTION, "QUitter le programme");
		}
		public void actionPerformed(ActionEvent e) {
			quitterProgramme();
		}
	}

		public void inscription() {
		//fermer la page de connexion 
		//r�diriger l'utilisateur dans le panneau d'inscription
		
	}
	

	
		
		/*
		private void parametres() {
			FParametres laFenetre = new FParametres();
			laFenetre.setVisible(true);
		}
		*/
		
		private void valider() {
			//valider la connexion de l'utilisateur
			
			//récupération de la saisie 
			String leNom = txtSaisieUtilisateur.getText(); 
			boolean ver = false;
			ModelDB db = null;
			
			String leMotDePasse = String.valueOf(pwdMotDePasse.getPassword());
			//Expression régulière mpd //mon mot de passse kA1@aa
			String regex = "^[^0-9](?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=]).{5,9}$";
			boolean verifier = Pattern.matches(regex, leMotDePasse);
			
			//modèle regex pour un  numéro portable : "^0[1-9][0-9]{8}$"
			
			if(verifier) {
				//connecter l'utilsiateur 
				db = new ModelDB();
				ver = db.ConnexionUtilisateur(leNom, leMotDePasse);
				if(ver) {
					//connexion réuissie
					btnValider.setEnabled(false);
					FConnexion.this.dispose();
							
					//changer de panneau
					afficherMenu();
				} else { 
				   //connexion  chouée
				        	
				} 	
			}
		}
		
		
	protected void afficherMenu() {
			FMenu FMenu = new FMenu();
			FMenu.setVisible(true);
	}


	public void quitterProgramme() {
		// TODO Auto-generated method stub
		dispose();
	}
	private class ActionEra extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ActionEra() {
			putValue(NAME, "Actio era");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Je suis era");
		}
	}
}
