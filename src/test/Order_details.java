package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order_details extends JFrame{

	private JPanel order_detail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_details window = new Order_details();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Order_details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 608);
		setTitle("Order Details");
		order_detail = new JPanel();
		setContentPane(order_detail);
		order_detail.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Taipei");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(36, 195, 111, 31);
		order_detail.add(lblNewLabel);
		
		JLabel lblTaichung = new JLabel("Taichung");
		lblTaichung.setHorizontalAlignment(SwingConstants.LEFT);
		lblTaichung.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblTaichung.setBounds(36, 278, 151, 31);
		order_detail.add(lblTaichung);
		
		JLabel lblTainan = new JLabel("Tainan");
		lblTainan.setHorizontalAlignment(SwingConstants.LEFT);
		lblTainan.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblTainan.setBounds(36, 367, 111, 31);
		order_detail.add(lblTainan);
		
		JLabel lblNewLabel_1 = new JLabel("台北市富錦街446號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(234, 203, 369, 23);
		order_detail.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("台南市長榮路１段１６１號");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(234, 375, 369, 23);
		order_detail.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("台中市文心路２段５６６―７號");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(234, 286, 369, 23);
		order_detail.add(lblNewLabel_1_2);
		
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(order_detail, "Your order is delivered to the chosen store!");
				CheckingCart.order.setStoreID(1);
				String query = "INSERT INTO order1 VALUES("+CheckingCart.order.getID()+","+CheckingCart.order.getStoreID()+","+CheckingCart.order.getUserID()+")";
				Connect con = new Connect();
				con.connect(query);
				
				Connect con30 = new Connect();
				
				for(int i=0;i<SeriesManagement.serie.size();i++) {
					con30.connect("INSERT INTO contain VALUES("+CheckingCart.order.getID()+","+SeriesManagement.serie.get(i).getID()+")");
				}
				
				String query2 = "SELECT * FROM store WHERE store_id="+CheckingCart.order.getStoreID();
				Connect con2 = new Connect();
				con2.connect(query2);
				Object data = con2.getData()[0][2];
				int TBA = (Integer) data;
				
				TBA+=SeriesManagement.serie.size();
				String query3 = "UPDATE store SET total_order_amount="+TBA+" "+"WHERE store_id="+CheckingCart.order.getStoreID();
				Connect con3 = new Connect();
				con3.connect(query3);
				
			}
		});
		btnChoose.setBounds(641, 197, 111, 31);
		order_detail.add(btnChoose);
		
		JButton btnChoose_1 = new JButton("Choose");
		btnChoose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(order_detail, "Your order is delivered to the chosen store!");
				CheckingCart.order.setStoreID(2);
				String query = "INSERT INTO order1 VALUES("+CheckingCart.order.getID()+","+CheckingCart.order.getStoreID()+","+CheckingCart.order.getUserID()+")";
				Connect con = new Connect();
				con.connect(query);
				
				Connect con30 = new Connect();
				
				for(int i=0;i<SeriesManagement.serie.size();i++) {
					con30.connect("INSERT INTO contain VALUES("+CheckingCart.order.getID()+","+SeriesManagement.serie.get(i).getID()+")");
				}
				
				String query2 = "SELECT * FROM store WHERE store_id="+CheckingCart.order.getStoreID();
				Connect con2 = new Connect();
				con2.connect(query2);
				Object data = con2.getData()[0][2];
				int TBA = (Integer) data;
				
				TBA+=SeriesManagement.serie.size();
				String query3 = "UPDATE store SET total_order_amount="+TBA+" "+"WHERE store_id="+CheckingCart.order.getStoreID();
				Connect con3 = new Connect();
				con3.connect(query3);
			}
		});
		btnChoose_1.setBounds(641, 280, 111, 31);
		order_detail.add(btnChoose_1);
		
		JButton btnChoose_2 = new JButton("Choose");
		btnChoose_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(order_detail, "Your order is delivered to the chosen store!");
				CheckingCart.order.setStoreID(3);
				String query = "INSERT INTO order1 VALUES("+CheckingCart.order.getID()+","+CheckingCart.order.getStoreID()+","+CheckingCart.order.getUserID()+")";
				Connect con = new Connect();
				con.connect(query);
				
				Connect con30 = new Connect();
				
				for(int i=0;i<SeriesManagement.serie.size();i++) {
					con30.connect("INSERT INTO contain VALUES("+CheckingCart.order.getID()+","+SeriesManagement.serie.get(i).getID()+")");
				}
				
				String query2 = "SELECT * FROM store WHERE store_id="+CheckingCart.order.getStoreID();
				Connect con2 = new Connect();
				con2.connect(query2);
				Object data = con2.getData()[0][2];
				int TBA = (Integer) data;
				
				TBA+=SeriesManagement.serie.size();
				String query3 = "UPDATE store SET total_order_amount="+TBA+" "+"WHERE store_id="+CheckingCart.order.getStoreID();
				Connect con3 = new Connect();
				con3.connect(query3);
			}
		});
		btnChoose_2.setBounds(641, 369, 111, 31);
		order_detail.add(btnChoose_2);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home_page hp = new Home_page(4);
				hp.setVisible(true);
			}
		});
		btnNewButton.setBounds(36, 493, 117, 29);
		order_detail.add(btnNewButton);
	}
}