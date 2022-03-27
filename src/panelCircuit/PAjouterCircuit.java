package panelCircuit;

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
import classesMetiers.ModelDB;
import net.miginfocom.swing.MigLayout;
import javax.swing.Action;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

//Panel
public class PAjouterCircuit extends JPanel {
	private static final long serialVersionUID = 1L;
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private JButton btnActionSauvegarder;
	private JPanel panel_principal;
	private JPanel panel_circuit;
	private JLabel lblNom;
	private JLabel lblTaille;
	private JLabel lblPays;
	private JLabel lblMessage;
	private JLabel lblAjouteCircuit;
	private JTextField textFieldPays;
	private JTextField textFieldNom;
	private JSpinner spinnerTaille;
	private JPanel panel;
	private JLabel lblListeDesCircuits;
	private final Action ActionAJoutCircuit = new ActionAJouterCircuit();
	private ModelDB db;
	
	//constructeur
	public PAjouterCircuit() {
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
		
		lblAjouteCircuit = new JLabel("Ajouter un circuit");
		lblAjouteCircuit.setForeground(Color.GRAY);
		lblAjouteCircuit.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblAjouteCircuit = new GridBagConstraints();
		gbc_lblAjouteCircuit.insets = new Insets(0, 0, 5, 0);
		gbc_lblAjouteCircuit.gridx = 0;
		gbc_lblAjouteCircuit.gridy = 0;
		panel_menu.add(lblAjouteCircuit, gbc_lblAjouteCircuit);
        
		
		
		//Action Sauvegarder
		btnActionSauvegarder = new JButton("Ajouter");
		btnActionSauvegarder.setAction(ActionAJoutCircuit);
		
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
				panel_circuit = new JPanel();
				panel_circuit.setOpaque(false);
				panel_circuit.setBorder(new CompoundBorder(
						new CompoundBorder(	new EmptyBorder(5, 5, 5, 5), 
											new TitledBorder(
													new LineBorder(new Color(0, 0, 0), 1, true),
													"Circuit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY)),
						new EmptyBorder(5, 5, 5, 5)));
				panel_principal.add(panel_circuit, "cell 0 1,grow");
				GridBagLayout gbl_panel_circuit = new GridBagLayout();
				gbl_panel_circuit.columnWidths = new int[] { 56, 146, 34, 146, 0 };
				gbl_panel_circuit.rowHeights = new int[] { 26, 26, 0, 0 };
				gbl_panel_circuit.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
						Double.MIN_VALUE };
				gbl_panel_circuit.rowWeights = new double[] { 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				panel_circuit.setLayout(gbl_panel_circuit);

				//Champs espece
				lblNom = new JLabel("Nom");
				lblNom.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblNom = new GridBagConstraints();
				gbc_lblNom.anchor = GridBagConstraints.WEST;
				gbc_lblNom.insets = new Insets(0, 0, 5, 5);
				gbc_lblNom.gridx = 0;
				gbc_lblNom.gridy = 0;
				panel_circuit.add(lblNom, gbc_lblNom);
				UI.habiller(lblNom);
				
				textFieldNom = new JTextField();
				GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
				gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldNom.gridx = 1;
				gbc_textFieldNom.gridy = 0;
				panel_circuit.add(textFieldNom, gbc_textFieldNom);
				textFieldNom.setColumns(10);
		        
				//Champs nom
				lblTaille = new JLabel("Taille");
				lblTaille.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblTaille = new GridBagConstraints();
				gbc_lblTaille.anchor = GridBagConstraints.WEST;
				gbc_lblTaille.insets = new Insets(0, 0, 5, 5);
				gbc_lblTaille.gridx = 2;
				gbc_lblTaille.gridy = 0;
				panel_circuit.add(lblTaille, gbc_lblTaille);
				UI.habiller(lblTaille);
				
				spinnerTaille = new JSpinner();
				GridBagConstraints gbc_spinnerTaille = new GridBagConstraints();
				gbc_spinnerTaille.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinnerTaille.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerTaille.gridx = 3;
				gbc_spinnerTaille.gridy = 0;
				panel_circuit.add(spinnerTaille, gbc_spinnerTaille);
		        
				//Champs adresse
				lblPays = new JLabel("Pays");
				lblPays.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
				GridBagConstraints gbc_lblPays = new GridBagConstraints();
				gbc_lblPays.anchor = GridBagConstraints.WEST;
				gbc_lblPays.insets = new Insets(0, 0, 5, 5);
				gbc_lblPays.gridx = 0;
				gbc_lblPays.gridy = 1;
				panel_circuit.add(lblPays, gbc_lblPays);
				UI.habiller(lblPays);
				
				textFieldPays = new JTextField();
				textFieldPays.setColumns(10);
				GridBagConstraints gbc_textFieldPays = new GridBagConstraints();
				gbc_textFieldPays.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldPays.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldPays.gridx = 1;
				gbc_textFieldPays.gridy = 1;
				panel_circuit.add(textFieldPays, gbc_textFieldPays);
				
				panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setForeground(Color.LIGHT_GRAY);
				panel_principal.add(panel, "cell 0 2,grow");
				
				lblListeDesCircuits = new JLabel("Les circuits");
				lblListeDesCircuits.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel.add(lblListeDesCircuits);
				
				
				
				
				
	}
	
    
 
	private class ActionAJouterCircuit extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ActionAJouterCircuit() {
			putValue(NAME, "Ajouter");
			putValue(SHORT_DESCRIPTION, "Ajouter un circuit");
		}
		public void actionPerformed(ActionEvent e) {
			ajouterCircuit();
		}
		
	}



	public void ajouterCircuit() {
		String nom = textFieldNom.getText();
		int taille = (int) spinnerTaille.getValue();
		String pays = textFieldPays.getText();
		
		//vérification des informations saisies
		if (nom != null  && taille !=0 && pays != null) {
			//ajouter la course
			boolean ver = db.ajouterCircuit(nom, taille, pays);
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
