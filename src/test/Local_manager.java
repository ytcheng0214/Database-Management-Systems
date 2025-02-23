package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Local_manager extends JFrame{

	private JPanel local;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Local_manager window = new Local_manager(1);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Local_manager(int state) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 608);
		setTitle("Local Manager");
		local = new JPanel();
		setContentPane(local);
		local.setLayout(null);
		
		JButton btnNewButton = new JButton("Order Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Order_info oi = new Order_info(state);
				oi.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(267, 138, 286, 42);
		local.add(btnNewButton);
		
		JButton btnProductInformation = new JButton("Product Information");
		btnProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Product_info pi = new Product_info(state);
				pi.setVisible(true);
			}
		});
		btnProductInformation.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnProductInformation.setBounds(267, 213, 286, 42);
		local.add(btnProductInformation);
		
		JButton btnCustomerInformation = new JButton("Customer Information");
		btnCustomerInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Customer_info ci = new Customer_info(state);
				ci.setVisible(true);
			}
		});
		btnCustomerInformation.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnCustomerInformation.setBounds(267, 288, 286, 42);
		local.add(btnCustomerInformation);
		
		JButton btnManagementOfStores = new JButton("Management of Store's Products");
		btnManagementOfStores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Management_SP sp = new Management_SP(state);
				sp.setVisible(true);
			}
		});
		btnManagementOfStores.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnManagementOfStores.setBounds(238, 364, 351, 42);
		local.add(btnManagementOfStores);
	}
}