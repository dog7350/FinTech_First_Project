package common;

import java.sql.*;

public class DBConnect {
	private static DBConnect instance = null;
	private static Connection con = null;
	private DBConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@fntc.kro.kr:1521:xe";
			
			con = DriverManager.getConnection(url, "fintech", "f1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnect getInstance() {
		if (instance == null) instance = new DBConnect();
		return instance;
	}
	
	public static Connection getConnect() { return con; }
}
