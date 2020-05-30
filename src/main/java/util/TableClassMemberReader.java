package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class TableClassMemberReader {
	
	public static String xmlTableReader(String table) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		
		Properties propXMLTables = new Properties();
		propXMLTables.loadFromXML(new FileInputStream(Thread.currentThread()
				.getContextClassLoader().getResource("").getPath() + "tables/tables.xml"));
		
		if(propXMLTables.containsKey(table)) {
			
			return propXMLTables.getProperty(table);
			
		}
		return null; 
	}

}
