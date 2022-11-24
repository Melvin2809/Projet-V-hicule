package InterfaceGraphique;

import java.awt.EventQueue;

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

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AjouterImage window = new AjouterImage();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				new AjouterImage();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjouterImage() {
		JFrame f = new JFrame("Ajouter une image dans JPanel");
		f.getContentPane().setBackground(new Color(255, 255, 255));
		f.setBackground(new Color(240, 240, 240));
		f.setBounds(300, 75, 950, 700);
		try {
		   JPanel panel = new JPanel();
		   panel.setBackground(new Color(255, 255, 255));
		   panel.setBounds(509, 38, 300, 194);
		   BufferedImage img = ImageIO.read(new File("Mercedes.jpg"));
		   JLabel pic = new JLabel(new ImageIcon(img));
		   panel.add(pic);
		   f.getContentPane().add(panel);
		   f.getContentPane().setLayout(null);
		   f.setVisible(true);
		   f.setResizable(false);
		  } catch (IOException e) {}
		   
		try {
			JPanel panel1 = new JPanel();
			panel1.setBackground(new Color(255, 255, 255));
			panel1.setBounds(139, 38, 300, 194);
			BufferedImage img1 = ImageIO.read(new File("Audi.jpg"));
			JLabel pic1 = new JLabel(new ImageIcon(img1));
		    panel1.add(pic1);
		    f.getContentPane().add(panel1);
		    f.getContentPane().setLayout(null);			   
		    f.setVisible(true);
			f.setResizable(false);
		   } catch (IOException e) {}
		
		try {
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(255, 255, 255));
			panel2.setBounds(139, 336, 300, 194);
			BufferedImage img2 = ImageIO.read(new File("Bmw.jpg"));
			JLabel pic2 = new JLabel(new ImageIcon(img2));
		    panel2.add(pic2);
		    f.getContentPane().add(panel2);
		    f.getContentPane().setLayout(null);			   
		    f.setVisible(true);
			f.setResizable(false);
		   } catch (IOException e) {}
		
		try {
			JPanel panel3 = new JPanel();
			panel3.setBackground(new Color(255, 255, 255));
			panel3.setBounds(509, 336, 300, 194);
			BufferedImage img3 = ImageIO.read(new File("Peugeot.jpg"));
			JLabel pic3 = new JLabel(new ImageIcon(img3));
		    panel3.add(pic3);
		    f.getContentPane().add(panel3);
		    f.getContentPane().setLayout(null);	
		   } catch (IOException e) {}
		    
		    JButton btnNewButton = new JButton("Afficher");
		    btnNewButton.setBounds(214, 253, 150, 35);
		    f.getContentPane().add(btnNewButton);
		    
		    JButton btnNewButton_1 = new JButton("Afficher");
		    btnNewButton_1.setBounds(582, 253, 150, 35);
		    f.getContentPane().add(btnNewButton_1);
		    
		    JButton btnNewButton_2 = new JButton("Afficher");
		    btnNewButton_2.setBounds(214, 555, 150, 35);
		    f.getContentPane().add(btnNewButton_2);
		    
		    JButton btnNewButton_3 = new JButton("Afficher");
		    btnNewButton_3.setBounds(582, 555, 150, 35);
		    f.getContentPane().add(btnNewButton_3);
		    f.setVisible(true);
			f.setResizable(false);
		   
			   
		}
			   
		//initialize();
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(273, 66, 319, 171);
		panel.add(lblNewLabel);
		frame.setBounds(300, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
