package InterfaceGraphique;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Dimension;

public class AjouterPanier<Dimension> {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(String Marque) {
				try {
					AjouterPanier window = new AjouterPanier(Marque);
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
	public AjouterPanier(String Marque) {
		initialize(Marque);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param marque 
	 */
	private void initialize(String Marque) {
		
		
		 String columns[] = { "ID", "prix", "marque" , "model", "couleur", "puissance", "vitesse"};
	      String data[][] = new String[5][7];
	      //DefaultTableModel model = new DefaultTableModel(data, columns);
	      JTable table = new JTable(data,columns);
	      
	      JFrame f = new JFrame(""); // Remplir JTable a partir d'une BDD
	      f.getContentPane().setLayout(null);
	      JPanel panel = new JPanel();
	      panel.setBounds(0, 0, 486, 151);
	      f.getContentPane().add(panel);
	      panel.setLayout(null);
	      JScrollPane pane = new JScrollPane(table);
	      pane.setBounds(17, 5, 452, 105);
	      pane.setVisible(true);
	      panel.add(pane);
	      table.setShowGrid(true);
		  table.setShowVerticalLines(true);
		  table.setFillsViewportHeight(true);
	
		
		  
		  String prix = null;
	      String marque = null;
	      String modell = null;
	      String id = null;
		try {
		String myDriver = "com.mysql.cj.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/projet";
	    
	      Connection con = DriverManager.getConnection(myUrl, "root", "root");
	    
	      PreparedStatement st = (PreparedStatement) con.prepareStatement("Select id_Vehicule,prix,marque,model,couleur,puissance_kw,vitesse_km_h from Vehicule where marque ="+ Marque);
	      ResultSet rs = st.executeQuery();
	      //int i = 0;
	      if(rs.next()) {
	        id = rs.getString("id_Vehicule");
	        prix = rs.getString("prix");
	        marque = rs.getString("marque");
	        modell = rs.getString("model");
	        String couleur = rs.getString("couleur");
	        String puissance_kw = rs.getString("puissance_kw");
	        String vitesse_km_h = rs.getString("vitesse_km_h");
	        
	      
	        data[0][0] = id;
	        data[0][1] = prix;
	        data[0][2] = marque;
	        data[0][3] = modell;
	        data[0][4] = couleur;
	        data[0][5] = puissance_kw;
	        data[0][6] = vitesse_km_h;
	        
	        //i++;
	      }
	        
	      
	        String prixx = prix;
		    String marquee = marque;
		    String modelll = modell;
		    String id_VEHICULE_Vehicule = id;
	   
	      JButton btnNewButton = new JButton("Ajouter au Panier");
	      btnNewButton.setBounds(171, 118, 145, 23);
	      panel.add(btnNewButton);
	      
	      f.setBounds(500, 75, 500, 198);
	      f.setResizable(false);
	      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      f.setVisible(true);
	      		    
	        
		    btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String iD_USER_isConnected;
							String iD_USER_panier = null;
							String ID_VEHICULE_panier = null;
							Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
							Statement st1 = conn.createStatement();
			            	ResultSet rs1 = st1.executeQuery("SELECT id_User FROM isConnected");
			            	while (rs1.next()) {
			        			//System.out.println("=) isConnected");
			            		iD_USER_isConnected = rs1.getString("id_User");
			            		
			            		try {
			                    	PreparedStatement st2 = (PreparedStatement) conn.prepareStatement("Select id_Vehicule,id_User From panier where id_User ="+ "'"+iD_USER_isConnected+"'");
			                    	ResultSet rs2 = st2.executeQuery();
			                    	while (rs2.next()) {
			                    		ID_VEHICULE_panier = rs2.getString("id_Vehicule");
			                    		iD_USER_panier = rs2.getString("id_User");
			                    		databaseUtil.ajouterPanier(iD_USER_isConnected, id_VEHICULE_Vehicule, marquee, modelll, prixx);
					            		JOptionPane.showMessageDialog(null, "Vous avez bien ajouté une "+marquee+" à votre panier =)", "Succès", JOptionPane.INFORMATION_MESSAGE);
			                    	}
			            		}catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}});
		
	    } catch(SQLException e) {
	      e.printStackTrace();
	    }
	  }
	}


