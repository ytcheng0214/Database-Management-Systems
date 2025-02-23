package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Management_SP extends JFrame{

	private JPanel sp;
	private JTextField textField;
	private JTextField textField_1;
	private UserManagement userManagement;
	private SeriesManagement seriesManagement;
	private static int state;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management_SP window = new Management_SP(state);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Management_SP(int state)  {
		this.userManagement = new UserManagement();
		setTitle("Management of Store's Products");
		setBounds(100, 100, 850, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sp = new JPanel();
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
		
		setContentPane(sp);
		sp.setLayout(null);

		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblCustomerId.setBounds(191, 186, 199, 38);
		sp.add(lblCustomerId);

		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblProductId.setBounds(502, 186, 130, 38);
		sp.add(lblProductId);

		textField = new JTextField();
		textField.setBounds(161, 256, 189, 29);
		sp.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(456, 256, 199, 29);
		sp.add(textField_1);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				int coutid = Integer.parseInt(textField.getText());
				int prodid = Integer.parseInt(textField_1.getText());
				User user = userManagement.findUserByID(coutid);
				
				String query6 = "SELECT * FROM contain WHERE product_id="+prodid;
				Connect con6 = new Connect();
				con6.connect(query6);
				Object data3 = con6.getData()[0][0];
				int TBA3 = (Integer) data3;
				
				String query7 = "SELECT * FROM order1 WHERE order_id="+TBA3;
				Connect con7 = new Connect();
				con7.connect(query7);
				Object data4 = con7.getData()[0][1];
				int TBA4 = (Integer) data4;
				System.out.println(TBA4);
				String query8 = "SELECT * FROM store WHERE store_id="+TBA4;
				Connect con8 = new Connect();
				con8.connect(query8);
				Object data5 = con8.getData()[0][4];
				int managerid = (Integer) data5;
				
				if (LoginPanel.ManagerID==managerid) {
					String query = "SELECT * FROM customer WHERE customer_id="+coutid;
					Connect con = new Connect();
					con.connect(query);
					Object data = con.getData()[0][5];
					int TBA = (Integer) data;
					TBA+=1;
					data = con.getData()[0][6];
					int Ttt = (Integer) data;
					String t = String.format("%.2f", (double)TBA/(Ttt)) ;
					System.out.println(t);
					String query2 = "UPDATE customer SET total_buy_amount="+ TBA +" WHERE customer_id="+coutid;
					String query10 = "UPDATE customer SET buy_ratio="+ t +" WHERE customer_id="+coutid;
					Connect con2 = new Connect();
					con2.connect(query2);
					con2.connect(query10);
					
					String query3 = "INSERT INTO buy VALUES("+coutid+","+prodid+")";
					
					Connect con3 = new Connect();
					con3.connect(query3);
					
					
					
					
					String query4 = "SELECT * FROM store WHERE store_id="+TBA4;
					Connect con4 = new Connect();
					con4.connect(query4);
					Object data2 = con4.getData()[0][3];
					int TBA2 = (Integer) data;
					TBA2+=1;
					
					String query5 = "UPDATE store SET total_sales_amount="+ TBA +" WHERE store_id="+TBA4;
					
					Connect con5 = new Connect();
					con5.connect(query5);
					JOptionPane.showMessageDialog(sp,"Update successfully!");
				}else {
					JOptionPane.showMessageDialog(sp,"you go to wrong store!");
				}
			}
		});
		btnSubmit.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnSubmit.setBounds(342, 337, 130, 38);
		sp.add(btnSubmit);
	}
}