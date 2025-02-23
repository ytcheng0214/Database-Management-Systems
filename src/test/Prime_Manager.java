package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prime_Manager extends JFrame{

	private JPanel prime;
	private static int state;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prime_Manager window = new Prime_Manager(state);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Prime_Manager(int state) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 608);
		setTitle("Prime Manager");
		prime = new JPanel();
		setContentPane(prime);	
		prime.setLayout(null);
		this.state = state;
		
		JButton btnNewButton = new JButton("Order Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Order_info oi = new Order_info(state);
				oi.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(263, 173, 286, 42);
		prime.add(btnNewButton);
		
		JButton btnProductInformation = new JButton("Product Information");
		btnProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Product_info pi = new Product_info(state);
				pi.setVisible(true);
			}
		});
		btnProductInformation.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnProductInformation.setBounds(263, 248, 286, 42);
		prime.add(btnProductInformation);
		
		JButton btnCustomerInformation = new JButton("Customer Information");
		btnCustomerInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Customer_info ci = new Customer_info(state);
				ci.setVisible(true);
			}
		});
		btnCustomerInformation.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnCustomerInformation.setBounds(263, 323, 286, 42);
		prime.add(btnCustomerInformation);
	}

}
