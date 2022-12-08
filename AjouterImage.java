package InterfaceGraphique;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class AjouterImage {

	private JFrame frameAjouter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(JFrame frameMenu) {
				try {
					AjouterImage window = new AjouterImage(frameMenu);
					window.getFrameAjouter().setVisible(true);
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
	public AjouterImage(JFrame frameMenu) {
		initialize(frameMenu);		  
		frameMenu.dispose();
		}
	
	
			   
	

	public JFrame getFrameAjouter() {
		return frameAjouter;
	}

	public void setFrameAjouter(JFrame frameAjouter) {
		this.frameAjouter = frameAjouter;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frameMenu) {
		
		JFrame frameAjouter = new JFrame("Catalogue de voitures");
		frameAjouter.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameAjouter.getContentPane().setBackground(new Color(255, 255, 255));
		frameAjouter.setBackground(new Color(240, 240, 240));
		frameAjouter.setBounds(300, 75, 950, 700);
		try {
		   JPanel panel = new JPanel();
		   panel.setBackground(new Color(255, 255, 255));
		   panel.setBounds(509, 38, 300, 194);
		   BufferedImage img = ImageIO.read(new File("Mercedes.jpg"));
		   JLabel pic = new JLabel(new ImageIcon(img));
		   panel.add(pic);
		   frameAjouter.getContentPane().add(panel);
		   frameAjouter.getContentPane().setLayout(null);
		   frameAjouter.setVisible(true);
		   frameAjouter.setResizable(false);
		  } catch (IOException e) {}
		   
		try {
			JPanel panel1 = new JPanel();
			panel1.setBackground(new Color(255, 255, 255));
			panel1.setBounds(139, 38, 300, 194);
			BufferedImage img1 = ImageIO.read(new File("Audi.jpg"));
			JLabel pic1 = new JLabel(new ImageIcon(img1));
		    panel1.add(pic1);
		    frameAjouter.getContentPane().add(panel1);
		    frameAjouter.getContentPane().setLayout(null);			   
		    frameAjouter.setVisible(true);
			frameAjouter.setResizable(false);
		   } catch (IOException e) {}
		
		try {
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(255, 255, 255));
			panel2.setBounds(139, 336, 300, 194);
			BufferedImage img2 = ImageIO.read(new File("Bmw.jpg"));
			JLabel pic2 = new JLabel(new ImageIcon(img2));
		    panel2.add(pic2);
		    frameAjouter.getContentPane().add(panel2);
		    frameAjouter.getContentPane().setLayout(null);			   
		    frameAjouter.setVisible(true);
			frameAjouter.setResizable(false);
		   } catch (IOException e) {}
		
		try {
			JPanel panel3 = new JPanel();
			panel3.setBackground(new Color(255, 255, 255));
			panel3.setBounds(509, 336, 300, 194);
			BufferedImage img3 = ImageIO.read(new File("Peugeot.jpg"));
			JLabel pic3 = new JLabel(new ImageIcon(img3));
		    panel3.add(pic3);
		    frameAjouter.getContentPane().add(panel3);
		    frameAjouter.getContentPane().setLayout(null);	
		   } catch (IOException e) {}
		    
		    JButton btnNewButton = new JButton("Afficher");
		    btnNewButton.setBounds(214, 253, 150, 35);
		    frameAjouter.getContentPane().add(btnNewButton);
		    
		    JButton btnNewButton_1 = new JButton("Afficher");
		    btnNewButton_1.setBounds(582, 253, 150, 35);
		    frameAjouter.getContentPane().add(btnNewButton_1);
		    btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AjouterPanier a = new AjouterPanier("'toyota'");
				}});
		    
		    
		    JButton btnNewButton_2 = new JButton("Afficher");
		    btnNewButton_2.setBounds(214, 555, 150, 35);
		    frameAjouter.getContentPane().add(btnNewButton_2);
		    btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AjouterPanier a = new AjouterPanier("'citroen'");
				}});
		    
		    
		    JButton btnNewButton_3 = new JButton("Afficher");
		    btnNewButton_3.setBounds(582, 555, 150, 35);
		    frameAjouter.getContentPane().add(btnNewButton_3);
		    btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AjouterPanier a = new AjouterPanier("'peugeot'");
				}});
		    
		    JButton btnNewButton_4 = new JButton("Retour");
		    btnNewButton_4.setBounds(22, 21, 78, 21);
		    btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame f = new JFrame(); // le constructeur de Menu a besoin de 2 JFrame en paramètres, donc on en créer sans utilité pour pouvoir utiliser ce constructeur et ne pas dupliquer le code de Initialize
					PagePrincipale p = new PagePrincipale(f,frameAjouter);
					p.getFramePrincipale().setVisible(true);
					frameAjouter.dispose();
				}});
		    frameAjouter.getContentPane().add(btnNewButton_4);
		    frameAjouter.setVisible(true);
			frameAjouter.setResizable(false);
	}
}
