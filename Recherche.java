package InterfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Recherche {

	private JFrame frame;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private String[] columns = new String[3];
	private String[][] data = new String[3][3] ;
	JButton button = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(JFrame frmGestionDeVente) {
				try {
					Recherche window = new Recherche(frmGestionDeVente);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Recherche(JFrame frmGestionDeVente) {
		initialize(frmGestionDeVente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frmGestionDeVente) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(350, 80, 877, 660);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		JTextField Marque = new JTextField();
		Marque.setBounds(284, 32, 96, 20);
		frame.getContentPane().add(Marque);
		Marque.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Veuillez entrer la marque d'une voiture  :");
		lblNewLabel.setBounds(21, 35, 253, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame(); // le constructeur de Menu a besoin de 2 JFrame en paramètres, donc on en créer sans utilité pour pouvoir utiliser ce constructeur et ne pas dupliquer le code de Initialize
				PagePrincipale p = new PagePrincipale(f,frame);
				p.getFramePrincipale().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(259, 113, 142, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(469, 31, 108, 21);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String myDriver = "com.mysql.cj.jdbc.Driver";
			    String myUrl = "jdbc:mysql://localhost:3306/projet";
			    try {
					Class.forName(myDriver);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	        	Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
	        	PreparedStatement st = (PreparedStatement) conn.prepareStatement("Select marque from Vehicule where marque="+"?");
	        	st.setString(1, Marque.getText());
	            ResultSet rs = st.executeQuery();
	          
	            if (rs.next()) {
	            	String marquee =rs.getString("marque");
	            	AjouterPanier a = new AjouterPanier("'"+marquee+"'");
	            } else {
	                JOptionPane.showMessageDialog(null, "Nos marques de voiture sont :\n peugeot \n citroen \n toyota", "Erreur", JOptionPane.ERROR_MESSAGE);
	            }
	        
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}	
				
			}});
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
