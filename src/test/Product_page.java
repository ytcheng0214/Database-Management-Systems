package test;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Product_page extends JFrame{

	private JPanel pro_page;
	private static int imagenum, state;
	public static Object[][]data = new Object[50][10];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_page window = new Product_page(state, imagenum);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Product_page(int state, int imagenum) {
		pro_page = new JPanel();
		setBounds(100, 100, 850, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Product Page");
		setContentPane(pro_page);	
		pro_page.setLayout(null);
		
		JButton btnNewButton = new JButton("GERBER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home_page hp = new Home_page(state);
				hp.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 18, 136, 49);
		pro_page.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Store");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StoreInfoPanel lp = new StoreInfoPanel(state);
				lp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(386, 30, 111, 31);
		pro_page.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Log in/Register");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginPanel lp = new LoginPanel(state);
				lp.main(null);
			}
		});
		btnNewButton_1_1.setBounds(512, 30, 157, 31);
		pro_page.add(btnNewButton_1_1);
		
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
		pro_page.add(btnNewButton_1_2);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		if(imagenum==1) {
			ImageIcon img1 = new ImageIcon(getClass().getResource("1.jpg"));
			JLabel lblNewLabel = new JLabel(img1);
			lblNewLabel.setBorder(blackline);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(65, 109, 314, 386);
			pro_page.add(lblNewLabel);
		}else if(imagenum==2) {
			ImageIcon img2 = new ImageIcon(getClass().getResource("2.jpg"));
			JLabel lblNewLabel = new JLabel(img2);
			lblNewLabel.setBorder(blackline);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(65, 109, 314, 386);
			pro_page.add(lblNewLabel);
		}else if(imagenum==3) {
			ImageIcon img3 = new ImageIcon(getClass().getResource("3.jpg"));
			JLabel lblNewLabel = new JLabel(img3);
			lblNewLabel.setBorder(blackline);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(65, 109, 314, 386);
			pro_page.add(lblNewLabel);
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(424, 126, 136, 23);
		pro_page.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Series");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(424, 180, 117, 23);
		pro_page.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Color");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(424, 234, 117, 23);
		pro_page.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Price");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(424, 288, 117, 23);
		pro_page.add(lblNewLabel_1_3);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (state!=1) {
					setVisible(false);
					LoginPanel lp = new LoginPanel(state);
					lp.main(null);
				}else {
					
					setVisible(false);
					SeriesManagement sm = new SeriesManagement();
					sm.addNewProduct((Integer)data[0][0],(String)data[0][1],(String)data[0][2],(String)data[0][3],(String)data[0][4]);
					CheckingCart cc = new CheckingCart();
					cc.setVisible(true);
				}
				
			}
		});
		btnNewButton_2.setBounds(649, 420, 117, 31);
		pro_page.add(btnNewButton_2);
		
		String query = "SELECT * FROM product WHERE product_name="+ "\'" + Home_page.productName + "\'"+" AND series="+"\'" + Home_page.seriesName + "\'";
		Connect con = new Connect();
		con.connect(query);
		data = con.getData();
		
		JLabel label = new JLabel((String)data[0][1]);
		label.setBounds(579, 126, 90, 23);
		pro_page.add(label);
		
		JLabel label_1 = new JLabel((String)data[0][3]);
		label_1.setBounds(579, 180, 90, 23);
		pro_page.add(label_1);
		
		JLabel label_2 = new JLabel((String)data[0][2]);
		label_2.setBounds(579, 234, 90, 23);
		pro_page.add(label_2);
		
		JLabel label_3 = new JLabel((String)data[0][4]);
		label_3.setBounds(579, 288, 90, 23);
		pro_page.add(label_3);
	}
}