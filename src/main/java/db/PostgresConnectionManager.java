package db;

//import java.io.FileInputStream;
//import java.io.IOException;

import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class PostgresConnectionManager {
	
	public static Connection getConnection() throws SQLException{
		
		String url = "jdbc:postgresql://localhost/auto-moto";
		
		Properties propsConn = new Properties();
		
//		propsConn.setProperty("user","postgres");
//		propsConn.setProperty("password","Baloxegal510212");
//		propsConn.setProperty("ssl","false");

//		Properties propsXML = new Properties();
//		propsXML.load(new FileInputStream("src/main/resources/config/config.xml"));
//		propsConn.setProperty("user", propsXML.getProperty("user"));
//		propsConn.setProperty("password",propsXML.getProperty("password"));
//		propsConn.setProperty("ssl",propsXML.getProperty("false"));
		
		System.out.println(SAXParserElement.user);
		System.out.println(SAXParserElement.password);
		System.out.println(SAXParserElement.ssl);

		propsConn.setProperty("user", SAXParserElement.user);
		propsConn.setProperty("password",SAXParserElement.password);
		propsConn.setProperty("ssl",SAXParserElement.ssl);
	
		Connection conn = DriverManager.getConnection(url, propsConn);
		return conn;
		
//		String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//		Connection conn = DriverManager.getConnection(url);
	}
}
