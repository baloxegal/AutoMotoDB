package util;

import java.util.Properties;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;


public class TableClassMemberReader {
	
	public static String xmlTableReader(String table) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		
		Properties propXMLTables = new Properties();
		propXMLTables.loadFromXML(new FileInputStream(Thread.currentThread()
				.getContextClassLoader().getResource("").getPath() + "tablesAndClassesRef/tablesAndClasses.xml"));
		
		if(propXMLTables.containsKey(table)) {
			
			return propXMLTables.getProperty(table);
		}
		return null; 
	}
}
