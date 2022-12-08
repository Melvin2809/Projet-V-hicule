package InterfaceGraphique;
import java.sql.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.Label;

public class Inscription {

	private JFrame frameInscription;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(JFrame frameW) {  // ajouter le frame de la 1ere page dans la 2eme
				try {
					Inscription window = new Inscription(frameW);  // ajouter le frame de la 1ere page dans la 2eme
					window.frameInscription.setVisible(true);
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
	public Inscription(JFrame frameW) { // dans le constructeur de la 2eme page mettre le frame de la 1ere page et dans initialize aussi pour ouvrir un frame à partir du bouton de la 1ere page
		initialize(frameW);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frameW) {
		frameInscription = new JFrame();
		frameInscription.setBounds(300, 75, 950, 700);
		frameInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInscription.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frameInscription.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextField nom = new JTextField();
		nom.setBounds(150, 88, 96, 19);
		panel.add(nom);
		nom.setColumns(10);
		
		
		JTextField prenom = new JTextField();
		prenom.setBounds(150, 132, 96, 19);
		panel.add(prenom);
		prenom.setColumns(10);
		
		
		JTextField mail = new JTextField();
		mail.setBounds(149, 180, 96, 19);
		panel.add(mail);
		mail.setColumns(10);
		
		JTextField ID = new JTextField();
		ID.setBounds(150, 220, 96, 19);
		panel.add(ID);
		ID.setColumns(10);
		
		JTextField PassWord = new JTextField();
		PassWord.setBounds(150, 261, 96, 19);
		panel.add(PassWord);
		PassWord.setColumns(10);
	
		
		JLabel lblNewLabel_0 = new JLabel("Nom");
		lblNewLabel_0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_0.setBounds(42, 88, 46, 13);
		panel.add(lblNewLabel_0);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(42, 134, 46, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresse mail");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(40, 184, 91, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(45, 226, 46, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PassWord");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(41, 264, 78, 13);
		panel.add(lblNewLabel_4);
		
		JLabel result = new JLabel("");
		result.setBounds(333, 295, 399, 33);
		panel.add(result);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(0, 0, 87, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowB w = new WindowB();
				w.getFrameW().setVisible(true);
				frameInscription.dispose(); 
			}});
		
		
		JButton btnNewButton = new JButton("Valider");
		
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (!nom.getText().equals("") && !prenom.getText().equals("") && !mail.getText().equals("")&&!ID.getText().equals("")&&!PassWord.getText().equals("")) {
						 try {
							 String myDriver = "com.mysql.cj.jdbc.Driver";
						      String myUrl = "jdbc:mysql://localhost/projet";
						      Class.forName(myDriver);
						      Connection conn = DriverManager.getConnection(myUrl, "root", "root");
						      databaseUtil.addUser("'"+nom.getText()+"'", "'"+prenom.getText()+"'", "'"+mail.getText()+"'", "'"+ID.getText()+"'", "'"+PassWord.getText()+"'", conn);
						      
						      String idUser="",prenomUser="";
				            	Statement st = conn.createStatement();
				            	ResultSet rs1 = st.executeQuery("SELECT id_User,prenom FROM User WHERE (user ="+"'"+ ID.getText()+"'" + "and passWord ="+"'"+PassWord.getText()+"')");
				        		while (rs1.next()) {
				        			//System.out.println("=) isConnected");
				        			idUser = rs1.getString("id_User");
				                	prenomUser = rs1.getString("prenom");
				        		}
				            	//Puis ajouter dans la table isConnected l'id et le prénom pour que dans l'appli
				        		//on puisse différencier un panier,une commande d'un autre user
				        		
				        		Statement st2 = conn.createStatement();
				            	String INSERT = "INSERT INTO isConnected(id_User,prenom) VALUES (" +"'"+idUser+"'" +","+"'"+prenomUser+"'"+")";
				            	st2.executeUpdate(INSERT);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 PagePrincipale p = new PagePrincipale(frameW,frameInscription);
						 p.getFramePrincipale().setVisible(true);
						 frameInscription.dispose(); 
						 
						 
					    }else {
							result.setText("Veuillez remplir tous les champs!");
				        }
						}});
		
		btnNewButton.setBounds(150, 361, 96, 33);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(436, 0, 501, 662);
		panel.add(panel_1);
		
		
		
		frameW.dispose();   // fermer la 1ère image quand on ouvre la 2ème ( à travers le boutton )
	}
	
	

	public Window getframeInscription() {
		// TODO Auto-generated method stub
		return frameInscription;
	}
}
