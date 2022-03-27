package panelVoiture;

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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import UI.UI;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;

//Panel
public class PAjouterVoiture extends JPanel {
	private static final long serialVersionUID = 1L;
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private JButton btnActionSauvegarder;
	private JPanel panel_principal;
	private JPanel panel_identite;
	private JLabel lblMarque;
	private JLabel lblModèle;
	private JLabel lblNbrCheveaux;
	private JLabel lblMessage;
	private JLabel lblAjouterVoiture;
	private JTextField textFieldMarque;
	private JTextField textFieldModèle;
	private JPanel panel_fonction;
	private JSpinner spinnerNbrCheveaux;
	
	
	//constructeur
	public PAjouterVoiture() {
		
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
		
		lblAjouterVoiture = new JLabel("Ajouter une voiture");
		lblAjouterVoiture.setForeground(Color.LIGHT_GRAY);
		lblAjouterVoiture.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblAjouterVoiture = new GridBagConstraints();
		gbc_lblAjouterVoiture.insets = new Insets(0, 0, 5, 0);
		gbc_lblAjouterVoiture.gridx = 0;
		gbc_lblAjouterVoiture.gridy = 0;
		panel_menu.add(lblAjouterVoiture, gbc_lblAjouterVoiture);
        
		
		
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
				lblMarque = new JLabel("Marque");
				lblMarque.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblMarque = new GridBagConstraints();
				gbc_lblMarque.anchor = GridBagConstraints.WEST;
				gbc_lblMarque.insets = new Insets(0, 0, 5, 5);
				gbc_lblMarque.gridx = 0;
				gbc_lblMarque.gridy = 0;
				panel_identite.add(lblMarque, gbc_lblMarque);
				UI.habiller(lblMarque);
				
				textFieldMarque = new JTextField();
				GridBagConstraints gbc_textFieldMarque = new GridBagConstraints();
				gbc_textFieldMarque.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldMarque.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldMarque.gridx = 1;
				gbc_textFieldMarque.gridy = 0;
				panel_identite.add(textFieldMarque, gbc_textFieldMarque);
				textFieldMarque.setColumns(10);
		        
				//Champs nom
				lblModèle = new JLabel("Modèle");
				lblModèle.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblModèle = new GridBagConstraints();
				gbc_lblModèle.anchor = GridBagConstraints.EAST;
				gbc_lblModèle.insets = new Insets(0, 0, 5, 5);
				gbc_lblModèle.gridx = 2;
				gbc_lblModèle.gridy = 0;
				panel_identite.add(lblModèle, gbc_lblModèle);
				UI.habiller(lblModèle);
				
				textFieldModèle = new JTextField();
				GridBagConstraints gbc_textFieldModèle = new GridBagConstraints();
				gbc_textFieldModèle.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldModèle.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldModèle.gridx = 3;
				gbc_textFieldModèle.gridy = 0;
				panel_identite.add(textFieldModèle, gbc_textFieldModèle);
				textFieldModèle.setColumns(10);
		        
				//Champs adresse
				lblNbrCheveaux = new JLabel("Nbr cheveaux");
				lblNbrCheveaux.setFont(new Font("Dialog", Font.PLAIN, 13));
				GridBagConstraints gbc_lblNbrCheveaux = new GridBagConstraints();
				gbc_lblNbrCheveaux.anchor = GridBagConstraints.WEST;
				gbc_lblNbrCheveaux.insets = new Insets(0, 0, 5, 5);
				gbc_lblNbrCheveaux.gridx = 0;
				gbc_lblNbrCheveaux.gridy = 1;
				panel_identite.add(lblNbrCheveaux, gbc_lblNbrCheveaux);
				UI.habiller(lblNbrCheveaux);
				
				spinnerNbrCheveaux = new JSpinner();
				GridBagConstraints gbc_spinnerNbrCheveaux = new GridBagConstraints();
				gbc_spinnerNbrCheveaux.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinnerNbrCheveaux.insets = new Insets(0, 0, 5, 5);
				gbc_spinnerNbrCheveaux.gridx = 1;
				gbc_spinnerNbrCheveaux.gridy = 1;
				panel_identite.add(spinnerNbrCheveaux, gbc_spinnerNbrCheveaux);
				
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
	}
	

    
 
}
