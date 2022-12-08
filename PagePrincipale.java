package InterfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Scrollbar;
import java.awt.Window;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagePrincipale {

	private JFrame framePrincipale;
	private JFrame frameInscription;

	
	

	public JFrame getFramePrincipale() {
		return framePrincipale;
	}

	public void setFramePrincipale(JFrame framePrincipale) {
		this.framePrincipale = framePrincipale;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(JFrame frameW,JFrame frameInscription) {
				try {
					PagePrincipale window = new PagePrincipale(frameW,frameInscription);
					window.framePrincipale.setVisible(true);
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
	public PagePrincipale(JFrame frameW, JFrame frameInscription) {
		initialize(frameW,frameInscription);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frameW, JFrame frameInscription) {
		framePrincipale = new JFrame();
		framePrincipale.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePrincipale.setBounds(350, 80, 877, 660);
		framePrincipale.getContentPane().setLayout(null);
		framePrincipale.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(442, 0, 420, 620);
		framePrincipale.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnP = new JButton("Panier");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panier p = new Panier(framePrincipale);
				p.getFramePanier().setVisible(true);
				framePrincipale.dispose();
			}
		});
		btnP.setBounds(314, 10, 79, 29);
		panel.add(btnP);
		
		JButton btnMesCommandes = new JButton("Mes Commandes");
		btnMesCommandes.setBounds(132, 183, 162, 35);
		framePrincipale.getContentPane().add(btnMesCommandes);
		
		JLabel lblNewLabel_1 = new JLabel("SmartCellCar");
		lblNewLabel_1.setFont(new Font("Lao MN", Font.BOLD, 20));
		lblNewLabel_1.setBounds(140, 7, 154, 29);
		framePrincipale.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnCatalogue = new JButton("Catalogue");
		btnCatalogue.setBounds(138, 225, 155, 30);
		framePrincipale.getContentPane().add(btnCatalogue);
		btnCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterImage A = new AjouterImage(framePrincipale);
				framePrincipale.dispose();
			}
		});
		
		
		JButton btnRechercher = new JButton("Recherche une voiture");
		btnRechercher.setBounds(119, 139, 190, 33);
		framePrincipale.getContentPane().add(btnRechercher);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recherche R = new Recherche(framePrincipale);
				R.getFrame().setVisible(true);
				framePrincipale.dispose();
			}});
		
	
		JButton btnSeDconnecter = new JButton("Se d\u00E9connecter");
		btnSeDconnecter.setBounds(150, 304, 125, 29);
		framePrincipale.getContentPane().add(btnSeDconnecter);
		btnSeDconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						databaseUtil.deconnexion();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				WindowB W = new WindowB();
				W.getFrameW().setVisible(true);
				framePrincipale.dispose();
			}});
 }

	public Window getFrameInscription() {
		// TODO Auto-generated method stub
		return frameInscription;
	}
}