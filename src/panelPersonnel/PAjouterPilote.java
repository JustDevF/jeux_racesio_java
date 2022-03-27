package panelPersonnel;


import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import UI.UI;
import net.miginfocom.swing.MigLayout;
import javax.swing.Action;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

//Panel
public class PAjouterPilote extends JPanel {
	private static final long serialVersionUID = 1L;
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private JButton btnActionSauvegarder;
	private JPanel panel_principal;
	private JPanel panel_identite;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblAdresse;
	private JLabel lblMessage;
	private JLabel lblAjouterPIlote;
	private JTextField textFieldAdresse;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JLabel lblVille;
	private JTextField textFieldVille;
	private JLabel lblCp;
	private JTextField textFieldCp;
	private JLabel lblNumero;
	private JLabel lblAMatricule;
	private JTextField textFieldMatricule;
	private JSpinner spinnerNumero;
	private JPanel panel_fonction;
	private JLabel lblEcurie;
	private JLabel lblPrenom_1;
	private JComboBox comboBoxEcurie;
	private JComboBox comboBoxVoiture;
	
	
	//constructeur
	public PAjouterPilote() {
		
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
		
		lblAjouterPIlote = new JLabel("Ajouter un pilote");
		lblAjouterPIlote.setForeground(Color.LIGHT_GRAY);
		lblAjouterPIlote.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblAjouterPIlote = new GridBagConstraints();
		gbc_lblAjouterPIlote.insets = new Insets(0, 0, 5, 0);
		gbc_lblAjouterPIlote.gridx = 0;
		gbc_lblAjouterPIlote.gridy = 0;
		panel_menu.add(lblAjouterPIlote, gbc_lblAjouterPIlote);
        
		
		
		//Action Sauvegarder
		btnActionSauvegarder = new JButton("Sauvegarder");
		
		btnActionSauvegarder.setForeground(Color.GRAY);
		btnActionSauvegarder.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		//configureAction(btnAction);
		btnActionSauvegarder.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnActionSauvegarder = new GridBagConstraints();
		gbc_btnActionSauvegarder.anchor = GridBagConstraints.LINE_START;
		gbc_btnActionSauvegarder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnActionSauvegarder.insets = new Insets(0, 0, 5, 0);
		gbc_btnActionSauvegarder.gridx = 0;
		gbc_btnActionSauvegarder.gridy = 1;
		btnActionSauvegarder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnActionSauvegarder, gbc_btnActionSauvegarder);
		
		
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
				
				
				//Panneau Etat-civil situ� dans le panneau formulaire
				panel_identite = new JPanel();
				panel_identite.setOpaque(false);
				panel_identite.setBorder(new CompoundBorder(
						new CompoundBorder(	new EmptyBorder(5, 5, 5, 5), 
											new TitledBorder(
													new LineBorder(new Color(0, 0, 0), 1, true),
													"Identité", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY)),
						new EmptyBorder(5, 5, 5, 5)));
				panel_principal.add(panel_identite, "cell 0 1,grow");
				GridBagLayout gbl_panel_identite = new GridBagLayout();
				gbl_panel_identite.columnWidths = new int[] { 56, 146, 34, 146, 0 };
				gbl_panel_identite.rowHeights = new int[] { 26, 26, 0, 0, 0 };
				gbl_panel_identite.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
						Double.MIN_VALUE };
				gbl_panel_identite.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				panel_identite.setLayout(gbl_panel_identite);

				//Champs espece
				lblNom = new JLabel("Nom");
				lblNom.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblNom = new GridBagConstraints();
				gbc_lblNom.anchor = GridBagConstraints.WEST;
				gbc_lblNom.insets = new Insets(0, 0, 5, 5);
				gbc_lblNom.gridx = 0;
				gbc_lblNom.gridy = 0;
				panel_identite.add(lblNom, gbc_lblNom);
				UI.habiller(lblNom);
				
				textFieldNom = new JTextField();
				GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
				gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldNom.gridx = 1;
				gbc_textFieldNom.gridy = 0;
				panel_identite.add(textFieldNom, gbc_textFieldNom);
				textFieldNom.setColumns(10);
		        
				//Champs nom
				lblPrenom = new JLabel("Prénom");
				lblPrenom.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
				gbc_lblPrenom.anchor = GridBagConstraints.EAST;
				gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrenom.gridx = 2;
				gbc_lblPrenom.gridy = 0;
				panel_identite.add(lblPrenom, gbc_lblPrenom);
				UI.habiller(lblPrenom);
				
				textFieldPrenom = new JTextField();
				GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
				gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldPrenom.gridx = 3;
				gbc_textFieldPrenom.gridy = 0;
				panel_identite.add(textFieldPrenom, gbc_textFieldPrenom);
				textFieldPrenom.setColumns(10);
		        
				//Champs adresse
				lblAdresse = new JLabel("Adresse");
				lblAdresse.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
				gbc_lblAdresse.anchor = GridBagConstraints.WEST;
				gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
				gbc_lblAdresse.gridx = 0;
				gbc_lblAdresse.gridy = 1;
				panel_identite.add(lblAdresse, gbc_lblAdresse);
				UI.habiller(lblAdresse);
				
				textFieldAdresse = new JTextField();
				textFieldAdresse.setColumns(10);
				GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
				gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldAdresse.gridx = 1;
				gbc_textFieldAdresse.gridy = 1;
				panel_identite.add(textFieldAdresse, gbc_textFieldAdresse);
				
				lblVille = new JLabel("Ville");
				lblVille.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblVille = new GridBagConstraints();
				gbc_lblVille.anchor = GridBagConstraints.WEST;
				gbc_lblVille.insets = new Insets(0, 0, 5, 5);
				gbc_lblVille.gridx = 2;
				gbc_lblVille.gridy = 1;
				panel_identite.add(lblVille, gbc_lblVille);
				
				textFieldVille = new JTextField();
				GridBagConstraints gbc_textFieldVille = new GridBagConstraints();
				gbc_textFieldVille.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldVille.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldVille.gridx = 3;
				gbc_textFieldVille.gridy = 1;
				panel_identite.add(textFieldVille, gbc_textFieldVille);
				textFieldVille.setColumns(10);
				
				lblAMatricule = new JLabel("Matricule");
				lblAMatricule.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblAMatricule = new GridBagConstraints();
				gbc_lblAMatricule.anchor = GridBagConstraints.EAST;
				gbc_lblAMatricule.insets = new Insets(0, 0, 5, 5);
				gbc_lblAMatricule.gridx = 0;
				gbc_lblAMatricule.gridy = 2;
				panel_identite.add(lblAMatricule, gbc_lblAMatricule);
				
				textFieldMatricule = new JTextField();
				GridBagConstraints gbc_textFieldMatricule = new GridBagConstraints();
				gbc_textFieldMatricule.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldMatricule.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldMatricule.gridx = 1;
				gbc_textFieldMatricule.gridy = 2;
				panel_identite.add(textFieldMatricule, gbc_textFieldMatricule);
				textFieldMatricule.setColumns(10);
				
				lblNumero = new JLabel("Numéro");
				lblNumero.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblNumero = new GridBagConstraints();
				gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumero.anchor = GridBagConstraints.EAST;
				gbc_lblNumero.gridx = 2;
				gbc_lblNumero.gridy = 2;
				panel_identite.add(lblNumero, gbc_lblNumero);
				
				spinnerNumero = new JSpinner();
				GridBagConstraints gbc_spinnerNumero = new GridBagConstraints();
				gbc_spinnerNumero.fill = GridBagConstraints.BOTH;
				gbc_spinnerNumero.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerNumero.gridx = 3;
				gbc_spinnerNumero.gridy = 2;
				panel_identite.add(spinnerNumero, gbc_spinnerNumero);
				
				lblCp = new JLabel("CP");
				lblCp.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblCp = new GridBagConstraints();
				gbc_lblCp.anchor = GridBagConstraints.WEST;
				gbc_lblCp.insets = new Insets(0, 0, 0, 5);
				gbc_lblCp.gridx = 0;
				gbc_lblCp.gridy = 3;
				panel_identite.add(lblCp, gbc_lblCp);
				
				textFieldCp = new JTextField();
				GridBagConstraints gbc_textFieldCp = new GridBagConstraints();
				gbc_textFieldCp.insets = new Insets(0, 0, 0, 5);
				gbc_textFieldCp.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCp.gridx = 1;
				gbc_textFieldCp.gridy = 3;
				panel_identite.add(textFieldCp, gbc_textFieldCp);
				textFieldCp.setColumns(10);
				
				panel_fonction = new JPanel();
				panel_fonction.setOpaque(false);
				panel_fonction.setBorder(new CompoundBorder(

										new CompoundBorder(	new EmptyBorder(5, 5, 5, 5), 

															new TitledBorder(

																	new LineBorder(new Color(0, 0, 0), 1, true),

																	"Fonctions", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY)),

										new EmptyBorder(5, 5, 5, 5)));
				panel_principal.add(panel_fonction, "cell 0 2,grow");
				GridBagLayout gbl_panel_fonction = new GridBagLayout();
				gbl_panel_fonction.columnWidths = new int[]{56, 146, 34, 146, 0};
				gbl_panel_fonction.rowHeights = new int[]{26, 26, 0, 0, 0};
				gbl_panel_fonction.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_fonction.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_fonction.setLayout(gbl_panel_fonction);
				
				lblEcurie = new JLabel("Ecurie");
				lblEcurie.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblEcurie = new GridBagConstraints();
				gbc_lblEcurie.anchor = GridBagConstraints.EAST;
				gbc_lblEcurie.insets = new Insets(0, 0, 5, 5);
				gbc_lblEcurie.gridx = 0;
				gbc_lblEcurie.gridy = 0;
				panel_fonction.add(lblEcurie, gbc_lblEcurie);
				
				comboBoxEcurie = new JComboBox();
				GridBagConstraints gbc_comboBoxEcurie = new GridBagConstraints();
				gbc_comboBoxEcurie.insets = new Insets(0, 0, 5, 5);
				gbc_comboBoxEcurie.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxEcurie.gridx = 1;
				gbc_comboBoxEcurie.gridy = 0;
				panel_fonction.add(comboBoxEcurie, gbc_comboBoxEcurie);
				
				lblPrenom_1 = new JLabel("Voiture");
				lblPrenom_1.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblPrenom_1 = new GridBagConstraints();
				gbc_lblPrenom_1.anchor = GridBagConstraints.EAST;
				gbc_lblPrenom_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrenom_1.gridx = 2;
				gbc_lblPrenom_1.gridy = 0;
				panel_fonction.add(lblPrenom_1, gbc_lblPrenom_1);
				
				comboBoxVoiture = new JComboBox();
				GridBagConstraints gbc_comboBoxVoiture = new GridBagConstraints();
				gbc_comboBoxVoiture.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxVoiture.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxVoiture.gridx = 3;
				gbc_comboBoxVoiture.gridy = 0;
				panel_fonction.add(comboBoxVoiture, gbc_comboBoxVoiture);		
	}
	

    
 
}
