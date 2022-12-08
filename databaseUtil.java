package InterfaceGraphique;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import InterfaceGraphique.PagePrincipale;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class databaseUtil  
{
	

	static public int addUser(String nom, String prenom,String mail,String user,String passWord, Connection conn) throws SQLException {
		String insert_query = "INSERT INTO User (nom,prenom,mail,user,passWord) VALUES("+nom+","+prenom+","+mail+","+user+","+passWord+")";
	    System.out.format(insert_query);
		Statement st = conn.createStatement();
		try {
			st.executeUpdate(insert_query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      st.close();
		return 0;
	}
	
	static public int printdatabase(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		String query = "SELECT * FROM User";
		ResultSet rs = st.executeQuery(query);
		while (rs.next())
		{
			String firstName = rs.getString("nom");  
			// print the results
			System.out.format("%s\n", firstName);
		}
		st.close();
		return 0;
	}
	
	
	static public void rechercheVoiture(String Marque,JButton btnNewButton) {

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
        	PreparedStatement st = (PreparedStatement) conn.prepareStatement("Select id_Vehicule,prix,marque,model,couleur,puissance_kw,vitesse_km_h from Vehicule where marque="+"?");
        	st.setString(1, Marque);
        	
            
            ResultSet rs = st.executeQuery();
          
            if (rs.next()) {
            	String prix = rs.getString("prix");
            	String marque = rs.getString("marque");
            	String model = rs.getString("model");
            	String couleur = rs.getString("couleur");
            	String puissance_kw = rs.getString("puissance_kw");
            	String vitesse_km_h = rs.getString("vitesse_km_h");
            	JOptionPane.showMessageDialog(null,"prix : "+ prix + "€\nmarque : "+ marque +"\nmodel : "+ model +"\ncouleur : "+couleur+"\npuissance_kw : "+puissance_kw+"\nvitesse_km : "+vitesse_km_h,"voiture", JOptionPane.INFORMATION_MESSAGE);
         
            } else {
                JOptionPane.showMessageDialog(null, "Cette marque n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
	}
	
	static public void afficherVoiture(String Marque) {

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
        	PreparedStatement st = (PreparedStatement) conn.prepareStatement("Select id_Vehicule,prix,marque,model,couleur,puissance_kw,vitesse_km_h from Vehicule where marque ="+ Marque);
        	ResultSet rs = st.executeQuery();
        	
        	if(rs.next()) {
                String prix = rs.getString("prix");
            	String marque = rs.getString("marque");
            	String model = rs.getString("model");
            	String couleur = rs.getString("couleur");
            	String puissance_kw = rs.getString("puissance_kw");
            	String vitesse_km_h = rs.getString("vitesse_km_h");
            	JOptionPane.showMessageDialog(null,"prix : "+ prix + "€\nmarque : "+ marque +"\nmodel : "+ model +"\ncouleur : "+couleur+"\npuissance_kw : "+puissance_kw+"\nvitesse_km : "+vitesse_km_h,"voiture", JOptionPane.INFORMATION_MESSAGE);
        	}
            
          
        }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}    
	}
	
	
	static public void connexion(String user, String password, JButton btnNewButton, JFrame frameW, JFrame frameInscription, JLabel result) {
		
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
        	PreparedStatement st = (PreparedStatement) conn.prepareStatement("Select user, passWord from User where user=? and passWord=?");
        	st.setString(1, user);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
          
            if (rs.next()) { // pour verifier mettre rs.next() à la place de true
                JOptionPane.showMessageDialog(btnNewButton, "Connexion réussie");
            	
            	//au moment de la connexion informer à la base de donées quel user est connecté
            	
                String idUser="",prenomUser="";
            	Statement st1 = conn.createStatement();
            	ResultSet rs1 = st.executeQuery("SELECT id_User,prenom FROM User WHERE (user ="+"'"+ user+"'" + "and passWord ="+"'"+password+"')");
        		System.out.println("SELECT id_User,prenom FROM User WHERE (user ="+"'"+ user+"'" + "and passWord ="+"'"+password+"')"+"\n");
            	while (rs1.next()) {
        			//System.out.println("=) isConnected");
        			idUser = rs1.getString("id_User");
                	prenomUser = rs1.getString("prenom");
        		}
            	//Puis ajouter dans la table isConnected l'id et le prénom pour que dans l'appli
        		//on puisse différencier un panier,une commande d'un autre user
        		
            	Statement st4 = conn.createStatement();
            	String INSERT4 = "delete from isConnected";
            	System.out.println(INSERT4+"\n");
            	st4.executeUpdate(INSERT4);
            	
        		Statement st2 = conn.createStatement();
            	String INSERT = "INSERT INTO isConnected(id_User,prenom) VALUES (" +"'"+idUser+"'" +","+"'"+prenomUser+"'"+")";
            	System.out.println(INSERT+"\n");
            	st2.executeUpdate(INSERT);
            	
            	// Faire savoir à panier2 quel user est connecté
            	Statement st3 = conn.createStatement();
            	String INSERT3 = "INSERT INTO panier2(id_User,prix) VALUES ("+idUser+","+-1+")";
            	System.out.println(INSERT3+"\n");
            	st3.executeUpdate(INSERT3);
            	
            	PagePrincipale p = new PagePrincipale(frameW,frameInscription);
                p.getFramePrincipale().setVisible(true);
                frameW.dispose(); 
            } else {
                JOptionPane.showMessageDialog(btnNewButton, "ID ou PassWord incorrect");
            }
        
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
        
		if(user.equals("")&&password.equals("")){
			 result.setText("Avez vous un compte?");
		}else if(!user.equals("")||!password.equals("")) {
			result.setText("ID ou PassWord incorrect");
		}
	}
	
	static public void deconnexion() throws SQLException {
		String myDriver = "com.mysql.cj.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/projet";
	    try {
	    	Class.forName(myDriver);
			} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}

        Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
		Statement stmt = stmt = conn.createStatement();
		String DELETE = "DELETE FROM isConnected";
		try {
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static public void ajouterPanier(String id_User,String id_Vehicule,String marque,String model,String prix) throws SQLException {
		String myDriver = "com.mysql.cj.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/projet";
	    Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
	    try {
	    	Class.forName(myDriver);
			} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
	      

        try {
        	
        	
        	String insert_query = "INSERT INTO panier2(id_User,id_Vehicule,marque,model,prix) VALUES("+ id_User +"," + id_Vehicule+"," +"'"+marque+"',"+"'"+model+"',"+"'"+prix+"')";
    	    System.out.format(insert_query+"\n");
    		Statement st = conn.createStatement();
    		try {
    			st.executeUpdate(insert_query);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	      st.close();
            
         	} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
          
            
	}
	
	static public double panierDuUser(String columns[],String data[][]) {

		// Somme du prix de chaque voiture
		double sum = 0;
		
		String myDriver = "com.mysql.cj.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/projet";
	    try {
	    	Class.forName(myDriver);
			} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
	
        try {
        	String ID_User = null;
        	Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
        	Statement st = conn.createStatement();
        	ResultSet rs = st.executeQuery("SELECT id_User FROM isConnected");
    		while (rs.next()) {
    			//System.out.println("=) isConnected");
    			ID_User = rs.getString("id_User");
    		}
    		
    		
    		Statement st4 = conn.createStatement();
        	String INSERT4 = "delete from panier2 where prix = -1";
        	System.out.println(INSERT4+"\n");
        	st4.executeUpdate(INSERT4);
    		
    		String query = "Select id_panier,id_Vehicule,id_User,marque,model,prix from panier2 where id_User ="+ID_User;
		    
		      Statement st1 = conn.createStatement();
		      ResultSet rs1 = st.executeQuery(query);
		    
		      double prix = 0;
		      String marque = null;
		      String modell = null;
		      int idUser = 0;
		      int idVehicule = 0;
		      int idPanier = 0;
	
		      while(rs1.next()) {
		    	int i = 0;
		    	idVehicule = rs1.getInt("id_Vehicule");
		    	idPanier = rs1.getInt("id_panier");
		    	idUser= rs1.getInt("id_User");
		        prix = rs1.getInt("prix");
		        marque = rs1.getString("marque");
		        modell = rs1.getString("model");
		        int j=0;
		        while(data[i][j]!=null) {i++;}
		        data[i][0] = idUser +"";
		        data[i][1] = idPanier + "";
		        data[i][2] = marque;
		        data[i][3] = modell;
		        data[i][4] = prix + " €";
		        i++;
		        sum+=prix;
		      }
    		
    		}catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    			}
        
        
        return sum;
	}

	public static void addCHOICE(JComboBox cb,JFrame framePanier) {
		try {
			String payss = null;
			String myDriver = "com.mysql.cj.jdbc.Driver";
        	String myUrl = "jdbc:mysql://localhost:3306/projet";
        	Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
        	Statement st = conn.createStatement();
        	ResultSet rs = st.executeQuery("SELECT pays FROM Pays");
    		while (rs.next()) {
    			//System.out.println("=) isConnected");
    			payss = rs.getString("pays");
   
    			
    		}
    		}catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    			}
	}
	
	
	public static void addTAXE(JComboBox j,JLabel l,JFrame f) {
		try {
			
			String taxee = null;
			String myDriver = "com.mysql.cj.jdbc.Driver";
        	String myUrl = "jdbc:mysql://localhost:3306/projet";
        	Connection conn = (Connection)DriverManager.getConnection(myUrl, "root", "root");
        	Statement st = conn.createStatement();
        	ResultSet rs = st.executeQuery("SELECT pays,taxe FROM Pays");
        	//String data = ""+ choice.getItem(choice.getSelectedIndex());  
			l.setText(taxee);
    			
    		
    		}catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
  public static void main(String[] args)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost/projet";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "root");
      databaseUtil.printdatabase(conn);
      //JavaConnexionMySql.addUser("tutu", "titi", conn);
      System.out.format("__________\n HELLO =)");
      //JavaConnexionMySql.printdatabase(conn);
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}