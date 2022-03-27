package panelCourse;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import UI.UI;
import classesMetiers.Circuit;
import classesMetiers.Course;
import classesMetiers.ModelDB;
import classesMetiers.Spectateur;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;


public class PAfficherCourses extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private JLabel lblTitre;
	private JButton btnImprimer;
	private JPanel panel_principal;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JButton btnNewButtonMessage;
	private ModelDB db;
	
	
	private JLabel lblMessage;
	private final Action ActionAfficheCourse = new ActionAfficherCourse();
	private JTextPane textPane;
	/**
	 * Création du panneau principal
	 */
	//constructeur
	public PAfficherCourses() {
		this.db = new ModelDB();
		//propriétes du panneau principal
		setBackground(new Color(0x33, 0xB5, 0xE5));
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		//Panneau menu situé à gauche du panneau principal
		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0x00, 0x99, 0xCC));
		add(panel_menu, BorderLayout.WEST);
		panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
				5)));
		GridBagLayout gbl_panel_menu = new GridBagLayout();
		gbl_panel_menu.columnWidths = new int[] { 0, 0 };
		gbl_panel_menu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_menu.setLayout(gbl_panel_menu);
		
		//titre du panneau
		lblTitre = new JLabel("Les couses");
		lblTitre.setIcon(null);
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.anchor = GridBagConstraints.LINE_START;
		gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panel_menu.add(lblTitre, gbc_lblTitre);
		lblTitre.setFont(new Font("Roboto", Font.BOLD, 18));
		
		btnNewButtonMessage = new JButton("Afficher");
		btnNewButtonMessage.setAction(ActionAfficheCourse);
		btnNewButtonMessage.setFont(new Font("Roboto Lt", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButtonMessage = new GridBagConstraints();
		gbc_btnNewButtonMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButtonMessage.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButtonMessage.gridx = 0;
		gbc_btnNewButtonMessage.gridy = 1;
		panel_menu.add(btnNewButtonMessage, gbc_btnNewButtonMessage);
		
		//champs pour afficher un message dans le panneau de menu gauche
		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Roboto Lt", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 2;
		panel_menu.add(lblMessage, gbc_lblMessage);
		
		//Action Imprimer
		btnImprimer = new JButton("print");
		btnImprimer.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		btnImprimer.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimer.anchor = GridBagConstraints.LINE_START;
		gbc_btnImprimer.gridx = 0;
		gbc_btnImprimer.gridy = 12;
		panel_menu.add(btnImprimer, gbc_btnImprimer);
		UI.deshabillerBouton(btnImprimer, "Printer");
		
		//Panneau central au centre du panneau principal
		panel_principal = new JPanel();
		panel_principal.setBackground(new Color(197, 234, 248));
		add(panel_principal, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("Courses");
		
		JScrollBar scrollBar = new JScrollBar();
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Roboto Lt", Font.PLAIN, 10));
		
		GroupLayout gl_panel_principal = new GroupLayout(panel_principal);
		gl_panel_principal.setHorizontalGroup(
			gl_panel_principal.createParallelGroup(Alignment.LEADING)
				.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
		);
		gl_panel_principal.setVerticalGroup(
			gl_panel_principal.createParallelGroup(Alignment.LEADING)
				.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
		);
		panel_principal.setLayout(gl_panel_principal);
		Border cadre = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		
	
		
	}
	private class ActionAfficherCourse extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ActionAfficherCourse() {
			putValue(NAME, "Afficher");
			putValue(SHORT_DESCRIPTION, "Afficher les courses");
		}
		public void actionPerformed(ActionEvent e) {
			afficherCourse();
		}
	}
	public void afficherCourse() {
		//vérifier s'il existe des courses 
		ArrayList<Course> lesCourses = db.recupCourses();
		Circuit uneCircuit;
		ArrayList<Spectateur> lesSpectateur = db.recupSpectateur();
		
		String result = "<Courses> \n";
		if(lesCourses.size() != 0) {
			for(Course uneCourse : lesCourses) {
				result +=  uneCourse.toXml() + "\n";
				uneCircuit = this.db.recupCircuit(uneCourse.getIdCircuit());
				result += "\t <Circuit> \n";
				result += uneCircuit.toXML();
				result += "\t </ Circuit> \n";
				
			}
			
			for(Spectateur unSpectateur : lesSpectateur) {
				result += unSpectateur.toXML() + "\n";
				
			}
			result += "</ Courses>";
			this.textPane.setText(result);
			this.lblMessage.setText("Résultats");
			this.lblMessage.setForeground(Color.CYAN);
		} else {
			this.textPane.setText("Il n'existe pas des courses disponibles");
			this.lblMessage.setText("Pas de résultats");
			this.lblMessage.setForeground(Color.RED);
		}
		
	}
}