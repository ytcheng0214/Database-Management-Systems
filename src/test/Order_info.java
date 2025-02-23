package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order_info extends JFrame{

	private JPanel order_info;
	private JTable table;
	private static int state;
	private static Object[][] data = new Object[][] {};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_info window = new Order_info(state);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Order_info(int state) {
		order_info = new JPanel();
		setBounds(100, 100, 850, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Order Information");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		this.state = state;
		
		JMenu mnNewMenu = new JMenu("Go Back");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Local Manager");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Local_manager oi = new Local_manager(state);
				oi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.setVisible(false);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Prime Manager");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Prime_Manager oi = new Prime_Manager(state);
				oi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem2);
		mntmNewMenuItem2.setVisible(false);
		
		if(state == 2) {
			mntmNewMenuItem2.setVisible(true);
		}else if(state == 3) {
			mntmNewMenuItem.setVisible(true);
		}
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Product Information");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Product_info oi = new Product_info(state);
				oi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Customer Information");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Customer_info oi = new Customer_info(state);
				oi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1_2);
		
		JMenuItem mntmNewMenuItem_1_2_1 = new JMenuItem("Management of store");
		mntmNewMenuItem_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Management_SP oi = new Management_SP(state);
				oi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1_2_1);
		mntmNewMenuItem_1_2_1.setVisible(false);
		if(state == 3) {
			mntmNewMenuItem_1_2_1.setVisible(true);
		}
		
		setContentPane(order_info);
		order_info.setLayout(null);
		
		
		JLabel lblOrferInformation = new JLabel("Order Information");
		lblOrferInformation.setFont(new Font("�蝝唳���", Font.PLAIN, 22));
		lblOrferInformation.setBounds(160, 115, 247, 35);
		order_info.add(lblOrferInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 172, 500, 266);
		order_info.add(scrollPane);
		
		if(LoginPanel.ManagerID == 304001) {
			String query = "SELECT * FROM order1";
			Connect con = new Connect();
			con.connect(query);
			data = con.getData();
		}else {
			String query = "SELECT * FROM order1 WHERE store_id="+LoginPanel.ManagerID;
			Connect con = new Connect();
			con.connect(query);
			data = con.getData();
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
		data ,new String[] {
				"Order ID", "Store ID", "Customer ID"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		scrollPane.setViewportView(table);
	}

}
