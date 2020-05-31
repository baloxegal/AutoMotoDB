package util;

import java.util.Properties;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.InvalidPropertiesFormatException;
import java.io.IOException;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnectionManager {
	
	public static Connection getConnection() throws SQLException, InvalidPropertiesFormatException,
													FileNotFoundException, IOException{
		
		String url = "jdbc:postgresql://localhost/auto-moto";
		
//		String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//		Connection conn = DriverManager.getConnection(url);
		
		Properties propsConn = new Properties();
		
//		propsConn.setProperty("user","postgres");
//		propsConn.setProperty("password","Baloxegal510212");
//		propsConn.setProperty("ssl","false");

		Properties propsXML = new Properties();
		
//		propsXML.loadFromXML(new FileInputStream("src/main/resources/config/config.xml"));
		
		propsXML.loadFromXML(new FileInputStream(Thread.currentThread()
							.getContextClassLoader().getResource("").getPath() + "config/configForConnect.xml"));
				
		propsConn.setProperty("user",propsXML.getProperty("user"));
		propsConn.setProperty("password",propsXML.getProperty("password"));
		propsConn.setProperty("ssl",propsXML.getProperty("ssl"));
	
		Connection conn = DriverManager.getConnection(url, propsConn);
		return conn;
	}
}
