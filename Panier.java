package InterfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JComboBox;

public class Panier<Dimension> {

	private JFrame framePanier;
	
	

	public JFrame getFramePanier() {
		return framePanier;
	}

	public void setFramePanier(JFrame framePanier) {
		this.framePanier = framePanier;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(JFrame framePrincipale) {
				try {
					Panier<?> window = new Panier<Object>(framePrincipale);
					window.framePanier.setVisible(true);
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
	public Panier(JFrame framePrincipale) {
		initialize(framePrincipale);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame framePrincipale) {
		framePanier = new JFrame();
		framePanier.setBounds(350, 80, 877, 660);
		framePanier.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePanier.getContentPane().setLayout(null);
		framePanier.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 471, 630);
		framePanier.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMonP = new JLabel("Mon Panier");
		lblMonP.setBounds(189, 12, 87, 19);
		lblMonP.setFont(new Font("Lao MN", Font.BOLD, 13));
		panel.add(lblMonP);
		
		JButton btnRetour = new JButton("retour\r\n");
		btnRetour.setFont(new Font("Dialog", Font.BOLD, 10));
		btnRetour.setBounds(20, 12, 90, 19);
		panel.add(btnRetour);
		;
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				PagePrincipale p = new PagePrincipale(f,framePanier);
			    p.getFramePrincipale().setVisible(true);
				framePanier.dispose(); 
			}});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(470, 1, 10, 629);
		framePanier.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("TOTAL");
		lblNewLabel.setFont(new Font("Lao MN", Font.BOLD, 13));
		lblNewLabel.setBounds(648, 9, 61, 16);
		framePanier.getContentPane().add(lblNewLabel);
		
		JLabel lblSoustotal = new JLabel("Sous-total");
		lblSoustotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoustotal.setBounds(514, 73, 106, 16);
		framePanier.getContentPane().add(lblSoustotal);
		
		JButton btnLivraison = new JButton("Livraison");
		btnLivraison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnLivraison.setFont(new Font("Lao MN", Font.BOLD, 10));
		btnLivraison.setBounds(514, 208, 90, 29);
		framePanier.getContentPane().add(btnLivraison);
		
		JLabel lblTaxe = new JLabel("Taxe");
		lblTaxe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTaxe.setBounds(514, 154, 61, 16);
		framePanier.getContentPane().add(lblTaxe);
		
		
		
		String columns[] = { "id_User","id_Vehicule", "marque" , "model", "prix"};
		String data[][] = new String[30][6];
		//DefaultTableModel model = new DefaultTableModel(data, columns);
		JTable table = new JTable(data, columns);
		JScrollPane pane = new JScrollPane(table); 
		table.setFillsViewportHeight(true);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		pane.setBackground(new Color(255, 255, 255));
	    pane.setBounds(10, 58, 452, 279);
	    panel.add(pane);  
		
	    
	    double sum;
	    // Afficher le panier du User actuel !
	    sum = databaseUtil.panierDuUser(columns,data);
	    
	    
	    framePanier.getContentPane().add(panel);
	    
	    JLabel lblNewLabel_2 = new JLabel("sum");
	    lblNewLabel_2.setText(""+sum+" €");
	    lblNewLabel_2.setBounds(648, 76, 103, 13);
	    framePanier.getContentPane().add(lblNewLabel_2);

	    
	    JLabel label = new JLabel("Pays");
	    label.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label.setBounds(514, 108, 59, 21);
	    framePanier.getContentPane().add(label);
	    
	    JLabel label_1 = new JLabel("taxe");
	    label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label_1.setBounds(641, 154, 59, 21);
	    framePanier.getContentPane().add(label_1);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(640, 109, 90, 21);
	    framePanier.getContentPane().add(comboBox);
	    
	    String[] items = new String[5];
	    
	    String myDriver = "com.mysql.cj.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/projet";
	    try {
	    	Class.forName(myDriver);
			} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
	
        try {
        	Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
        	Statement st = conn.createStatement();
        	ResultSet rs = st.executeQuery("SELECT pays FROM Pays");

        	
        	int i = 0;
	    	while(rs.next()) {
	    		items[i]= rs.getString("pays");
	    	}
	    
	    	new JComboBox<Object>(items);
        }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		comboBox.addActionListener(new ActionListener() {     
		     @Override
		     public void actionPerformed(ActionEvent e) {
		        System.out.println("Valeur: " + comboBox.getSelectedItem().toString());      
		     }
		   });
		  
		   framePanier.getContentPane().add(comboBox);
	 
		    
	}
	}
