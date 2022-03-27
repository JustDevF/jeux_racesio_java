package panelCourse;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import UI.UI;
import classesMetiers.ModelDB;
import net.miginfocom.swing.MigLayout;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;



public class PAjouterCourse extends JPanel {
	private static final long serialVersionUID = 1L;
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private JButton btnAction;
	private JPanel panel_principal;
	private JPanel panel_circuit;
	private JCheckBox cartefidelite;
	private JPanel panel_course;
	private JLabel lblPrenom;
	private JLabel lblNom;
	private JLabel lblAdresse;
	private JLabel lblCodepostal;
	private JLabel lblAfficheMessage;
	private JLabel lblMessage;
	private JLabel lblAjoutchat;
	private JTextField textFieldDate;
	private JTextField textFieldType;
	private JTextField textFieldNom;
	private JSpinner SpinnernbrSpectateur;
	private JSpinner idCIrcuit;
	private final Action AjouterCourse = new ActionAjouterCouse();
	private ModelDB db;
	

	

	/**
	 * Cr�ation du panneau 
	 */
	
	//constructeur
	public PAjouterCourse() {
		
		this.db = new ModelDB();
		
		//propriétés panneau principal
		setBackground(Color.LIGHT_GRAY);
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
        
		//Panneau menu situé à gauche du panneau principal
		panel_menu = new JPanel();
		panel_menu.setForeground(Color.WHITE);
		panel_menu.setBackground(Color.DARK_GRAY);
		add(panel_menu, BorderLayout.WEST);
		panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
				5)));
		GridBagLayout gbl_panel_menu = new GridBagLayout();
		gbl_panel_menu.columnWidths = new int[] { 0, 0 };
		gbl_panel_menu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_menu.setLayout(gbl_panel_menu);
		
		lblAjoutchat = new JLabel("Ajouter une course");
		lblAjoutchat.setForeground(Color.GRAY);
		lblAjoutchat.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblAjoutchat = new GridBagConstraints();
		gbc_lblAjoutchat.insets = new Insets(0, 0, 5, 0);
		gbc_lblAjoutchat.gridx = 0;
		gbc_lblAjoutchat.gridy = 0;
		panel_menu.add(lblAjoutchat, gbc_lblAjoutchat);
        
		//Actions disponibles
		
		//Action Sauvegarder
		btnAction = new JButton("Sauvegarder");
		btnAction.setAction(AjouterCourse);
		
		btnAction.setForeground(Color.GRAY);
		btnAction.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		//configureAction(btnAction);
		btnAction.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnAction = new GridBagConstraints();
		gbc_btnAction.anchor = GridBagConstraints.LINE_START;
		gbc_btnAction.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAction.insets = new Insets(0, 0, 5, 0);
		gbc_btnAction.gridx = 0;
		gbc_btnAction.gridy = 1;
		btnAction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnAction, gbc_btnAction);
		
		//Champs pour afficher les informations d'ajout client
		lblAfficheMessage = new JLabel("");
		lblAfficheMessage.setFont(new Font("Roboto Lt", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAfficheMessage = new GridBagConstraints();
		gbc_lblAfficheMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblAfficheMessage.gridx = 0;
		gbc_lblAfficheMessage.gridy = 2;
		panel_menu.add(lblAfficheMessage, gbc_lblAfficheMessage);
		
		lblMessage = new JLabel("Remplier le formulair ");
		lblMessage.setForeground(Color.LIGHT_GRAY);
		lblMessage.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 3;
		panel_menu.add(lblMessage, gbc_lblMessage);

		//Panneau central au centre du panneau principal
				panel_principal = new JPanel();
				panel_principal.setBackground(Color.LIGHT_GRAY);
				add(panel_principal, BorderLayout.CENTER);
				panel_principal.setLayout(new MigLayout("", "[grow]", "[][][grow][grow]"));
		        
				//Panneau formulaire en haut du panneau centrale
				panel_circuit = new JPanel();
				panel_circuit.setOpaque(false);
				panel_circuit.setBorder(new CompoundBorder(
						new CompoundBorder(	new EmptyBorder(5, 5, 5, 5), 
											(Border) new TitledBorder(
													new LineBorder(new Color(0, 0, 0), 1, true),
													"Circuit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY)),
						new EmptyBorder(5, 5, 5, 5)));
				
				panel_principal.add(panel_circuit, "cell 0 0 4 1,grow");
				GridBagLayout gbl_panel_circuit = new GridBagLayout();
				gbl_panel_circuit.columnWidths = new int[] { 79, 0, 182, 91, 182, 119 };
				gbl_panel_circuit.rowHeights = new int[] { 26 };
				gbl_panel_circuit.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0,
						0.0 };
				gbl_panel_circuit.rowWeights = new double[] { 1.0 };
				panel_circuit.setLayout(gbl_panel_circuit);
				
				String s1[] = { "Java", "PHP", "Python", "C++", "Ruby" };JLabel lblCircuit = new JLabel("IDCircuit");
				lblCircuit.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblCircuit = new GridBagConstraints();
				gbc_lblCircuit.anchor = GridBagConstraints.WEST;
				gbc_lblCircuit.insets = new Insets(0, 0, 0, 5);
				gbc_lblCircuit.gridx = 0;
				gbc_lblCircuit.gridy = 0;
				panel_circuit.add(lblCircuit, gbc_lblCircuit);
				UI.habiller(lblCircuit);
				
				idCIrcuit = new JSpinner();
				GridBagConstraints gbc_idCIrcuit = new GridBagConstraints();
				gbc_idCIrcuit.insets = new Insets(0, 0, 0, 5);
				gbc_idCIrcuit.gridx = 1;
				gbc_idCIrcuit.gridy = 0;
				panel_circuit.add(idCIrcuit, gbc_idCIrcuit);
		        
				//CheckBox Carte de fidelit�
				cartefidelite = new JCheckBox("valider");
				cartefidelite.setEnabled(false);
				cartefidelite.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				cartefidelite.setOpaque(false);
				GridBagConstraints gbc_chckbxCartefidelite = new GridBagConstraints();
				gbc_chckbxCartefidelite.anchor = GridBagConstraints.NORTHWEST;
				gbc_chckbxCartefidelite.gridx = 5;
				gbc_chckbxCartefidelite.gridy = 0;
				panel_circuit.add(cartefidelite, gbc_chckbxCartefidelite);
				UI.habiller(cartefidelite);
				
				//Panneau Etat-civil situ� dans le panneau formulaire
				panel_course = new JPanel();
				panel_course.setOpaque(false);
				panel_course.setBorder(new CompoundBorder(
						new CompoundBorder(	new EmptyBorder(5, 5, 5, 5), 
											new TitledBorder(
													new LineBorder(new Color(0, 0, 0), 1, true),
													"Course", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY)),
						new EmptyBorder(5, 5, 5, 5)));
				panel_principal.add(panel_course, "cell 0 1,grow");
				GridBagLayout gbl_panel_course = new GridBagLayout();
				gbl_panel_course.columnWidths = new int[] { 56, 146, 34, 146, 0 };
				gbl_panel_course.rowHeights = new int[] { 26, 26, 0, 0 };
				gbl_panel_course.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
						Double.MIN_VALUE };
				gbl_panel_course.rowWeights = new double[] { 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				panel_course.setLayout(gbl_panel_course);

				//Champs espece
				lblPrenom = new JLabel("Nom");
				lblPrenom.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
				gbc_lblPrenom.anchor = GridBagConstraints.WEST;
				gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrenom.gridx = 0;
				gbc_lblPrenom.gridy = 0;
				panel_course.add(lblPrenom, gbc_lblPrenom);
				UI.habiller(lblPrenom);
				
				textFieldNom = new JTextField();
				GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
				gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldNom.gridx = 1;
				gbc_textFieldNom.gridy = 0;
				panel_course.add(textFieldNom, gbc_textFieldNom);
				textFieldNom.setColumns(10);
		        
				//Champs nom
				lblNom = new JLabel("TypeCourse");
				lblNom.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblNom = new GridBagConstraints();
				gbc_lblNom.anchor = GridBagConstraints.WEST;
				gbc_lblNom.insets = new Insets(0, 0, 5, 5);
				gbc_lblNom.gridx = 2;
				gbc_lblNom.gridy = 0;
				panel_course.add(lblNom, gbc_lblNom);
				UI.habiller(lblNom);
				
				textFieldType = new JTextField();
				GridBagConstraints gbc_textFieldType = new GridBagConstraints();
				gbc_textFieldType.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldType.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldType.gridx = 3;
				gbc_textFieldType.gridy = 0;
				panel_course.add(textFieldType, gbc_textFieldType);
				textFieldType.setColumns(10);
		        
				//Champs adresse
				lblAdresse = new JLabel("Date");
				lblAdresse.setForeground(Color.BLACK);
				lblAdresse.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
				gbc_lblAdresse.anchor = GridBagConstraints.WEST;
				gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
				gbc_lblAdresse.gridx = 0;
				gbc_lblAdresse.gridy = 1;
				panel_course.add(lblAdresse, gbc_lblAdresse);
				UI.habiller(lblAdresse);
				
				textFieldDate = new JTextField();
				textFieldDate.setEditable(false);
				textFieldDate.setColumns(10);
				GridBagConstraints gbc_textFieldDate = new GridBagConstraints();
				gbc_textFieldDate.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldDate.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldDate.gridx = 1;
				gbc_textFieldDate.gridy = 1;
				panel_course.add(textFieldDate, gbc_textFieldDate);
				
				//Champs code postal 
				lblCodepostal = new JLabel("NbSpéctateur");
				lblCodepostal.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblCodepostal = new GridBagConstraints();
				gbc_lblCodepostal.anchor = GridBagConstraints.EAST;
				gbc_lblCodepostal.insets = new Insets(0, 0, 5, 5);
				gbc_lblCodepostal.gridx = 2;
				gbc_lblCodepostal.gridy = 1;
				panel_course.add(lblCodepostal, gbc_lblCodepostal);
				UI.habiller(lblCodepostal);
				
				
				SpinnernbrSpectateur = new JSpinner();
				GridBagConstraints gbc_SpinnernbrSpectateur = new GridBagConstraints();
				gbc_SpinnernbrSpectateur.fill = GridBagConstraints.HORIZONTAL;
				gbc_SpinnernbrSpectateur.insets = new Insets(0, 0, 5, 0);
				gbc_SpinnernbrSpectateur.gridx = 3;
				gbc_SpinnernbrSpectateur.gridy = 1;
				panel_course.add(SpinnernbrSpectateur, gbc_SpinnernbrSpectateur);
				Border cadre = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
							
	}
	  
	//action
	private class ActionAjouterCouse extends AbstractAction {
		public ActionAjouterCouse() {
			putValue(NAME, "Ajouter");
			putValue(SHORT_DESCRIPTION, "AJouter la course");
		}
		public void actionPerformed(ActionEvent e) {
			ajouterCourse();
		}
	}

	//Méthode 
	public void ajouterCourse() {

		int idCircuit = (int) idCIrcuit.getValue();
		String nom = textFieldNom.getText();
		String type = textFieldType.getText();
		int nbrSpectateur = (int) SpinnernbrSpectateur.getValue();
		
		//vérification des informations saisies
		if (idCircuit != 0 && nom != null  && nbrSpectateur !=0) {
			//ajouter la course
			boolean ver = db.ajouterCourse(nom, type, nbrSpectateur, idCircuit);
			if(ver) {
				this.lblMessage.setText("Ajout avec réussi");
				this.lblMessage.setForeground(Color.CYAN);
			} else {
				this.lblMessage.setText("Ajout échoué erreur bd");
				this.lblMessage.setForeground(Color.RED);
			}
		} else {
			this.lblMessage.setText("Vérifier vos informations");
			this.lblMessage.setForeground(Color.RED);
		}

	}
}
