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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product_info extends JFrame{

	private JPanel pro_info;
	private JTable table;
	private static int state;
	private static Object[][] data = new Object[][] {};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_info window = new Product_info(state);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Product_info(int state){
		setTitle("Product Informaiton");
		setBounds(100, 100, 850, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pro_info = new JPanel();
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

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Order Information");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Order_info oi = new Order_info(state);
				oi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

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
		setContentPane(pro_info);
		pro_info.setLayout(null);

		JLabel lblOrferInformation = new JLabel("Product Information");
		lblOrferInformation.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblOrferInformation.setBounds(160, 115, 259, 35);
		pro_info.add(lblOrferInformation);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 172, 500, 266);
		pro_info.add(scrollPane);
		
		String query = "SELECT * FROM product";
		Connect con = new Connect();
		con.connect(query);
		data = con.getData();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				data,
				new String[] {
						"Product ID", "Product Name", "Color", "Series", "Price"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(1).setPreferredWidth(121);
		table.getColumnModel().getColumn(2).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		scrollPane.setViewportView(table);
	
	}

}
