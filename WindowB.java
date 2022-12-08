package InterfaceGraphique;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class WindowB {

	private JFrame frameW;
	private JTextField textField;
	private JTextField textField_1;
	protected JFrame frameInscription;
	private JPasswordField passwordField;
	
	

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		String userHomeDir = System.getProperty("user.home");
       // System.out.printf("The User Home Directory is %s", userHomeDir);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowB window = new WindowB();
					window.frameW.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	
	public JFrame getFrameW() {
		return frameW;
	}

	public void setFrameW(JFrame frameW) {
		this.frameW = frameW;
	}


	/**
	 * Create the application.
	 */
	public WindowB(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <UserHome>
	 */
	private <UserHome> void initialize() {
		frameW = new JFrame();
		frameW.getContentPane().setBackground(new Color(255, 255, 255));
		frameW.setBounds(350, 80, 877, 660);
		frameW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameW.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 567, 1);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.GRAY);
		frameW.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("SmartSellCar");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(75, 6, 156, 25);
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(105, 105, 105));
		panel_3.setBounds(502, 0, 361, 677);
		frameW.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Inscription");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription i = new Inscription(frameW);
				i.getframeInscription().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(145, 356, 112, 29);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBounds(55, 140, 262, 206);
		panel_3.add(panel_4_1);
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.WHITE);
		
		JTextField  user= new JTextField();
		user.setBounds(80, 23, 130, 26);
		panel_4_1.add(user);
		user.setColumns(10);
		
		
		
		JLabel result = new JLabel("");
		result.setBounds(62, 123, 160, 21);
		panel_4_1.add(result);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Lao Sangam MN", Font.BOLD, 13));
		lblNewLabel_2.setBounds(25, 27, 60, 21);
		panel_4_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Passeword");
		lblNewLabel_2_1.setFont(new Font("Lao Sangam MN", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(6, 81, 68, 22);
		panel_4_1.add(lblNewLabel_2_1);
		
		JPasswordField passWord = new JPasswordField();
		passWord.setBounds(80, 81, 130, 26);
		panel_4_1.add(passWord);
		
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(54, 154, 168, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inUser = user.getText();
				String inPassWord = passWord.getText();
				
				databaseUtil.connexion(inUser, inPassWord, btnNewButton, frameW, frameInscription, result);
			}});
		
		panel_4_1.add(btnNewButton);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(154, 11, 216, 36);
		frameW.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("SmartSellCar");
		lblNewLabel_1.setFont(new Font("Lao MN", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
	
	
	
	
	try {
		BufferedImage img = ImageIO.read(new File("pngtree-vector-car-icon-png-image_515825.jpg"));
		   frameW.getContentPane().setLayout(null);
		   JLabel pic = new JLabel(new ImageIcon(img));
		   pic.setBounds(-15, -53, 519, 730);
		   frameW.getContentPane().add(pic);
		   frameW.setVisible(true);
		   frameW.setResizable(false);
		  } catch (IOException e) {}
	}   
}

	
