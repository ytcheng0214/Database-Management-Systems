package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LoginPanel{

	private JFrame frame;
	private JTextField LoginpasswordtextField;
	private JTextField LoginEmailTextField;
	private JTextField RegisterPasswordTextField;
	private JTextField RegisterEmailTextField;
	private JTextField RegisterNameTextField;
	private JTextField RegisterPhoneTextField;
	public static int userIDcurrent;
	private int userIDcount; 
	private UserManagement userManagement;
	private static int state;
	public static int ManagerID;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel(state);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPanel(int stat) {
		initialize();
		if(stat!=1 && stat!=2 && stat!=3) {
			state = 4;
		}
	}
	private void initialize() {
		userManagement = new UserManagement();
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 850, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login/Register");
		frame.getContentPane().setLayout(null);
		
		JPanel Loginpanel = new JPanel();
		Loginpanel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Loginpanel.setBackground(new Color(245, 245, 220));
		Loginpanel.setForeground(new Color(255, 250, 240));
		Loginpanel.setBounds(129, 181, 300, 258);
		frame.getContentPane().add(Loginpanel);
		Loginpanel.setLayout(null);

		LoginpasswordtextField = new JTextField();
		LoginpasswordtextField.setBounds(106, 109, 160, 26);
		Loginpanel.add(LoginpasswordtextField);
		LoginpasswordtextField.setColumns(10);

		LoginEmailTextField = new JTextField();
		LoginEmailTextField.setColumns(10);
		LoginEmailTextField.setBounds(106, 37, 160, 26);
		Loginpanel.add(LoginEmailTextField);

		JLabel LoginEmailLabel = new JLabel("e-mail :");
		LoginEmailLabel.setBounds(26, 42, 61, 16);
		Loginpanel.add(LoginEmailLabel);

		JLabel LoginpasswordLabel = new JLabel("password :");
		LoginpasswordLabel.setBounds(26, 114, 68, 16);
		Loginpanel.add(LoginpasswordLabel);

		JButton LoginButton = new JButton("Login");
		LoginButton.setBounds(56, 199, 185, 37);
		Loginpanel.add(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginEmail = LoginEmailTextField.getText();
				String loginpassword = LoginpasswordtextField.getText();
				if (loginEmail!=null && loginpassword!=null) {
					User userNow = userManagement.findUserEmailPass(loginEmail,loginpassword);
					if(userNow != null) {
						LoginEmailTextField.setText("");
						LoginpasswordtextField.setText("");
						if (userNow.getID()>304004) { 
							state = 1;
							frame.dispose();
							Home_page hp = new Home_page(state);
							hp.setVisible(true);
							SeriesManagement.serie.clear();
							userManagement.addNewUserToAL(userNow);
							userIDcurrent = userNow.getID();
						}else if(userNow.getID()>304001) {  
							state = 3;
							frame.dispose();
							Local_manager lm = new Local_manager(state);
							lm.setVisible(true);
							ManagerID = userNow.getID();
						}else if(userNow.getID() == 304001) {  
							state = 2;
							frame.dispose();
							Prime_Manager pm = new Prime_Manager(state);
							pm.setVisible(true);
							ManagerID = userNow.getID();
						}
					}
					else {
						JOptionPane.showMessageDialog(frame,"your account do not exist, please register firstlly.");
					}

				}
			}

		});

		JPanel Registerpanel = new JPanel();
		Registerpanel.setLayout(null);
		Registerpanel.setForeground(new Color(255, 250, 240));
		Registerpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Registerpanel.setBackground(new Color(245, 245, 220));
		Registerpanel.setBounds(441, 181, 300, 258);
		frame.getContentPane().add(Registerpanel);

		RegisterPasswordTextField = new JTextField();
		RegisterPasswordTextField.setColumns(10);
		RegisterPasswordTextField.setBounds(106, 75, 160, 26);
		Registerpanel.add(RegisterPasswordTextField);

		RegisterEmailTextField = new JTextField();
		RegisterEmailTextField.setColumns(10);
		RegisterEmailTextField.setBounds(106, 37, 160, 26);
		Registerpanel.add(RegisterEmailTextField);

		JLabel RegisterEmailLabel = new JLabel("e-mail :");
		RegisterEmailLabel.setBounds(26, 42, 61, 16);
		Registerpanel.add(RegisterEmailLabel);

		JLabel RegisterPasswordLabel = new JLabel("password :");
		RegisterPasswordLabel.setBounds(26, 80, 68, 16);
		Registerpanel.add(RegisterPasswordLabel);

		RegisterNameTextField = new JTextField();
		RegisterNameTextField.setColumns(10);
		RegisterNameTextField.setBounds(106, 111, 160, 26);
		Registerpanel.add(RegisterNameTextField);

		JLabel RegisterNameLabel = new JLabel("name :");
		RegisterNameLabel.setBounds(26, 116, 68, 16);
		Registerpanel.add(RegisterNameLabel);

		JLabel RegisterPhoneLabel = new JLabel("phone :");
		RegisterPhoneLabel.setBounds(26, 154, 68, 16);
		Registerpanel.add(RegisterPhoneLabel);

		RegisterPhoneTextField = new JTextField();
		RegisterPhoneTextField.setColumns(10);
		RegisterPhoneTextField.setBounds(106, 149, 160, 26);
		Registerpanel.add(RegisterPhoneTextField);

		JButton signButton = new JButton("Sign up");
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String registerEmail = RegisterEmailTextField.getText();
				String registerPassword = RegisterPasswordTextField.getText();
				String registerName = RegisterNameTextField.getText();
				String registerPhone = RegisterPhoneTextField.getText();

				if (registerEmail!=null && registerPassword!=null && registerName!=null && registerPhone!=null) {
					if(userManagement.findUserEmailPass(registerEmail,registerPassword)==null) {
						
						String query = "SELECT * FROM customer ORDER BY customer_id DESC LIMIT 1";
						Connect con = new Connect();
						con.connect(query);
						Object[][] data = con.getData();
						userIDcount = ((Integer)data[0][0]) + 1;
			
						userManagement.addNewUserToDB(userIDcount, registerEmail, registerPhone, registerName, registerPassword);
						RegisterEmailTextField.setText("");
						RegisterPasswordTextField.setText("");
						RegisterNameTextField.setText("");
						RegisterPhoneTextField.setText("");
						JOptionPane.showMessageDialog(frame,"Register successfully, Please login again!");
					}else {
						JOptionPane.showMessageDialog(frame,"Email and password has already exists!");
					}
				}else {
					JOptionPane.showMessageDialog(frame,"You fill out the information incomplete!");
				}
			}
		});
		signButton.setBounds(64, 200, 185, 37);
		Registerpanel.add(signButton);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 838, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton HomePageButton = new JButton("GERBER");
		HomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home_page hp = new Home_page(state);
				hp.setVisible(true);
			}
		});
		HomePageButton.setBounds(26, 18, 136, 49);
		panel.add(HomePageButton);
		HomePageButton.setBackground(Color.LIGHT_GRAY);

		JButton LoginRegisterButton = new JButton("Login/Register");
		LoginRegisterButton.setBounds(512, 30, 157, 31);
		panel.add(LoginRegisterButton);
		LoginRegisterButton.setBackground(Color.LIGHT_GRAY);

		JButton StoreButton = new JButton("Store");
		StoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StoreInfoPanel nw = new StoreInfoPanel(state);				
				nw.setVisible(true);

			}
		});
		StoreButton.setBounds(386, 30, 111, 31);
		panel.add(StoreButton);
		StoreButton.setBackground(Color.LIGHT_GRAY);

		JButton CartButton = new JButton("Cart");
		CartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (state == 1) {
					frame.dispose();
					CheckingCart cc = new CheckingCart();
					cc.setVisible(true);	
				}

			}
		});
		CartButton.setBounds(684, 30, 111, 31);
		panel.add(CartButton);
		CartButton.setBackground(Color.LIGHT_GRAY);
	}
}
