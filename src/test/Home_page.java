package test;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_page extends JFrame{

	private JPanel home;
    private static int state;
    public static String productName;
    public static String seriesName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page(state);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home_page(int state) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 608);
		home = new JPanel();
		this.state = state;
		setContentPane(home);	
		home.setLayout(null);
		
		

		JButton btnNewButton = new JButton("GERBER");
		btnNewButton.setBounds(26, 18, 136, 49);
		home.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Store");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StoreInfoPanel lp = new StoreInfoPanel(state);
				lp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(386, 30, 111, 31);
		home.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Log in/Register");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginPanel lp = new LoginPanel(state);
				lp.main(null);
			}
		});
		btnNewButton_1_1.setBounds(512, 30, 157, 31);
		home.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Cart");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (state!=1) {
					setVisible(false);
					LoginPanel lp = new LoginPanel(state);
					lp.main(null);
				}else {
					setVisible(false);
					CheckingCart cc = new CheckingCart();
					cc.setVisible(true);
				}
				
			}
		});
		btnNewButton_1_2.setBounds(684, 30, 111, 31);
		home.add(btnNewButton_1_2);
		ImageIcon img1 = new ImageIcon(getClass().getResource("1.jpg"));
		JButton btnNewButton_2 = new JButton(img1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName = "鬆緊帶寬褲";
				seriesName = "褲子";
				setVisible(false);
				Product_page cc = new Product_page(state,1);
				cc.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(55, 141, 229, 341);
		home.add(btnNewButton_2);
		
		ImageIcon img2 = new ImageIcon(getClass().getResource("2.jpg"));
		JButton btnNewButton_2_1 = new JButton(img2);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName = "連袖大衣";
				seriesName = "外套";
				setVisible(false);
				Product_page cc = new Product_page(state,2);
				cc.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(310, 141, 229, 341);
		home.add(btnNewButton_2_1);
		
		ImageIcon img3 = new ImageIcon(getClass().getResource("3.jpg"));
		JButton btnNewButton_2_2 = new JButton(img3);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName = "胸細褶洋裝";
				seriesName = "上衣";
				setVisible(false);
				Product_page cc = new Product_page(state,3);
				cc.setVisible(true);
			}
		});
		btnNewButton_2_2.setBounds(566, 141, 229, 341);
		home.add(btnNewButton_2_2);
		
		JLabel lblNewLabel = new JLabel("胸細褶洋裝");
		lblNewLabel.setBounds(656, 494, 111, 16);
		home.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("上衣");
		lblNewLabel_1.setBounds(670, 528, 111, 16);
		home.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("連袖大衣");
		lblNewLabel_2.setBounds(396, 494, 111, 16);
		home.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("外套");
		lblNewLabel_1_1.setBounds(406, 528, 111, 16);
		home.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("鬆緊帶寬褲");
		lblNewLabel_3.setBounds(145, 494, 111, 16);
		home.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("褲子");
		lblNewLabel_1_2.setBounds(160, 528, 111, 16);
		home.add(lblNewLabel_1_2);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		
	}
}