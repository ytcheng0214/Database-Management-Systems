package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Connect {
	private Object[][] data;
	public Connect() {
		data = new Object[50][10];
	}
	public void connect(String query) {
		try {
			String server ="jdbc:mysql://localhost:3306/";
			String database = "dbms-project";
			String url = server + database;
			String username = "root";
			String password = "gerbar510575";
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stat = conn.createStatement();
			boolean hasResultSet = stat.execute(query);
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();
				getResultSet(result);
				result.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}					
	}
	public void getResultSet(ResultSet result) throws SQLException {
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		int j=0;
		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				data[j][i-1] = result.getObject(i);
			}
			j+=1;
		}

	}
	public Object[][] getData(){
		return this.data;
	}
}
