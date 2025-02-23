package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManagement {
	public static ArrayList<User> users = new ArrayList<User>();
	public UserManagement() {
	}
	public void addNewUserToAL(User user) {
		users.add(user);
	}
	public void addNewUserToDB(int id, String email, String phone, String name, String password) {
		String server ="jdbc:mysql://localhost:3306/";
		String database = "dbms-project";
		String url = server + database;
		String username = "root";
		String Password = "gerbar510575";
		try {
			String query = "INSERT INTO customer (customer_id,email,phone,name,password,total_buy_amount,total_order_amount,buy_ratio) VALUES (?,?,?,?,?,0,0,0)";
			Connection conn = DriverManager.getConnection(url,username,Password);
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,id);
			stat.setString(2,email);
			stat.setString(3,phone);
			stat.setString(4,name);
			stat.setString(5,password);
			stat.execute();
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	public User findUserByID(int userID) {
		for (User user : users) {
			if (userID == user.getID()) {
				return user;
			}
		}
		return null;
	}
	
	public User findUserEmailPass(String email, String password) {
		String query = "SELECT * FROM customer WHERE email="+ "\'" + email + "\'"+" AND password="+"\'" + password + "\'";
		Connect con = new Connect();
		con.connect(query);
		Object[][] data = con.getData();
		if(data[0][0] == null) {
			String query2 = "SELECT * FROM employee WHERE email="+ "\'" + email + "\'"+" AND password="+"\'" + password + "\'";
			Connect con2 = new Connect();
			con2.connect(query2);
			data = con2.getData();
		}
		if(data[0][0] == null) {
			return null;
		}
		else {
			if((Integer)data[0][0]>=304005) {
				User user = new User((Integer)data[0][0],(String)data[0][1],(String)data[0][2],(String)data[0][3],(String)data[0][4],(Integer)data[0][5],(Integer)data[0][6]);
				return user;
			}else {
				User user = new User((Integer)data[0][0],(String)data[0][1],(String)data[0][2],(String)data[0][3],(String)data[0][4]);
				return user;
			}
		}
	}		
}




