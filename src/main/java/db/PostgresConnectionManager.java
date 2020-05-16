package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnectionManager {
	
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:postgresql://localhost/auto-moto";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","Baloxegal510212");
		props.setProperty("ssl","false");
		Connection conn = DriverManager.getConnection(url, props);
		return conn;
		
		//String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
		//Connection conn = DriverManager.getConnection(url);
	}
}
