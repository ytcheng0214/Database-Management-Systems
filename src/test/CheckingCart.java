package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckingCart extends JFrame{

	private JPanel cart;
	private JTable table;
	private static Object[][] product ;
	public static Order order;
	private int orderid;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckingCart window = new CheckingCart();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CheckingCart() {
		String query = "SELECT * FROM order1 ORDER BY order_id DESC LIMIT 1";
		Connect con = new Connect();
		con.connect(query);
		Object data = con.getData()[0][0];
		orderid = (Integer) data;
		this.order = new Order(orderid+1,LoginPanel.userIDcurrent);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 608);
		cart = new JPanel();
		setContentPane(cart);
		cart.setLayout(null);
		
		JButton btnGoBackShopping = new JButton("Go Back Shopping");
		btnGoBackShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home_page lp = new Home_page(1);
				lp.setVisible(true);
			}
		});
		btnGoBackShopping.setBounds(578, 58, 169, 41);
		cart.add(btnGoBackShopping);
		

		
		JButton btnChexk = new JButton("Check");
		btnChexk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM customer WHERE customer_id="+LoginPanel.userIDcurrent;
				Connect con = new Connect();
				con.connect(query);
				Object data = con.getData()[0][6];
				int TBA = (Integer) data;
				data = con.getData()[0][5];
				int Ttt = (Integer) data;
				
				TBA+=SeriesManagement.serie.size();
				String t = String.format("%.2f", (double)Ttt/(TBA));
				String query2 = "UPDATE customer SET total_order_amount="+TBA+" "+"WHERE customer_id="+LoginPanel.userIDcurrent;
				String query3 = "UPDATE customer SET buy_ratio="+t+" "+"WHERE customer_id="+LoginPanel.userIDcurrent;
				Connect con2 = new Connect();
				con2.connect(query2);
				Connect con100 = new Connect();
				con100.connect(query3);
				setVisible(false);
				Order_details lp = new Order_details();
				lp.setVisible(true);
			}
		});
		btnChexk.setBounds(643, 457, 111, 31);
		cart.add(btnChexk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 151, 505, 258);
		cart.add(scrollPane);
		
		
		
		product = new Object[SeriesManagement.serie.size()][4];
		for(int i=0;i<SeriesManagement.serie.size();i++) {
			this.getProduct()[i][0] = SeriesManagement.serie.get(i).getName();
			this.getProduct()[i][1] = SeriesManagement.serie.get(i).getColor();
			this.getProduct()[i][2] = SeriesManagement.serie.get(i).getSeries();
			this.getProduct()[i][3] = SeriesManagement.serie.get(i).getPrice();
		}
		table = new JTable();
		table.setModel(new DefaultTableModel(
			product,
			new String[] {
				"Product", "Color","Series","Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}
	public Object[][] getProduct(){
		return this.product;
	}
	public Order getOrder() {
		return this.order;
	}
}