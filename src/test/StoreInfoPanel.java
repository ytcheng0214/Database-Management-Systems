package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class StoreInfoPanel extends JFrame{

	private JPanel store;
	private static int state;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreInfoPanel window = new StoreInfoPanel(state);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StoreInfoPanel(int state) {
		store = new JPanel();
		setBounds(100, 100, 850, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(store);	
		store.setLayout(null);
		this.state = state;
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(6, 6, 794, 83);
		store.add(panel);
		
		JButton HomePageButton = new JButton("GERBER");
		HomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home_page lp = new Home_page(state);
				lp.setVisible(true);
				
			}
		});
		HomePageButton.setBackground(Color.LIGHT_GRAY);
		HomePageButton.setBounds(26, 18, 136, 49);
		panel.add(HomePageButton);
		
		JButton LoginRegisterButton = new JButton("Login/Register");
		LoginRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginPanel lp = new LoginPanel(state);
				lp.main(null);

			}
		});
		LoginRegisterButton.setBackground(Color.LIGHT_GRAY);
		LoginRegisterButton.setBounds(512, 30, 157, 31);
		panel.add(LoginRegisterButton);
		
		JButton StoreButton = new JButton("Store");
		StoreButton.setBackground(Color.LIGHT_GRAY);
		StoreButton.setBounds(386, 30, 111, 31);
		panel.add(StoreButton);
		
		JButton CartButton = new JButton("Cart");
		CartButton.addActionListener(new ActionListener() {
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
		CartButton.setBackground(Color.LIGHT_GRAY);
		CartButton.setBounds(684, 30, 111, 31);
		panel.add(CartButton);
		
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBackground(new Color(245, 245, 220));
		InfoPanel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Store Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Store Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		InfoPanel.setBounds(157, 179, 508, 232);
		store.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		JLabel StoreLabel_1 = new JLabel("Taipei Store");
		StoreLabel_1.setBounds(46, 55, 87, 16);
		InfoPanel.add(StoreLabel_1);
		
		JLabel StoreLabel_2 = new JLabel("Taichung Store");
		StoreLabel_2.setBounds(46, 102, 102, 16);
		InfoPanel.add(StoreLabel_2);
		
		JLabel StoreLabel_3 = new JLabel("Tainan Store");
		StoreLabel_3.setBounds(46, 153, 87, 16);
		InfoPanel.add(StoreLabel_3);
		
		JLabel Address_1 = new JLabel("台北市松山區富錦街446號");
		Address_1.setBounds(183, 55, 232, 16);
		InfoPanel.add(Address_1);
		
		JLabel Address_2 = new JLabel("臺中市西屯區何成里文心路２段５６６―７號");
		Address_2.setBounds(183, 102, 290, 16);
		InfoPanel.add(Address_2);
		
		JLabel Address_3 = new JLabel("臺南市東區泉南里長榮路１段１６１號");
		Address_3.setBounds(183, 153, 290, 16);
		InfoPanel.add(Address_3);
	}

}
