import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Index1 extends JFrame{

	private JFrame frmBlueroll;
	private JTextField Username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index1 window = new Index1();
					window.frmBlueroll.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlueroll = new JFrame();
		frmBlueroll.setTitle("BlueRoll");
		frmBlueroll.getContentPane().setBackground(SystemColor.window);
		frmBlueroll.setBounds(100, 100, 1000, 500);
		frmBlueroll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlueroll.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(208, 30, 546, 102);
		label.setIcon(new ImageIcon(Index1.class.getResource("/images/BlueRollLogo.jpg")));
		frmBlueroll.getContentPane().add(label);
		
		Username = new JTextField();
		Username.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		Username.setForeground(SystemColor.controlText);
		Username.setBounds(426, 255, 171, 25);
		frmBlueroll.getContentPane().add(Username);
		Username.setColumns(10);
		
		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		password.setForeground(SystemColor.controlText);
		password.setBounds(426, 301, 171, 25);
		password.setColumns(6);
		frmBlueroll.getContentPane().add(password);
		
		JLabel lblNewLabel = new JLabel("USERNAME -");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(288, 251, 107, 37);
		frmBlueroll.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD -");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(288, 300, 111, 22);
		frmBlueroll.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("   LOGIN PAGE");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 26));
		lblNewLabel_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_2.setBounds(411, 163, 161, 49);
		frmBlueroll.getContentPane().add(lblNewLabel_2);
		
		JButton Login = new JButton("LOGIN");
		Login.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent arg0) 
				{
						String user= Username.getText();
						String pass= password.getText();
						
						if(user.equals("chs") & pass.equals("123"))
						{
							frmBlueroll.dispose();
							new User().setVisible(true);
						}
						else {
														
							JOptionPane.showMessageDialog (null,"Invalid Login");
						}
	
		}});
		Login.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		Login.setForeground(new Color(70, 130, 180));
		Login.setBounds(452, 350, 97, 25);
		
		frmBlueroll.getContentPane().add(Login);
		
		JButton forgotpassword = new JButton("FORGOT PASSWORD?");
		forgotpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		forgotpassword.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		forgotpassword.setForeground(new Color(70, 130, 180));
		forgotpassword.setBounds(396, 394, 226, 25);
		frmBlueroll.getContentPane().add(forgotpassword);
	
		
		
	}
}
