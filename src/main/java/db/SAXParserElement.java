package db;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

public class SAXParserElement {
	
	protected static String user;
	protected static String password;
	protected static String ssl;
		
	public static void xmlSAXParserElement () {
		
		SAXParserFactory factoryDoc = SAXParserFactory.newInstance();
		SAXParser parserDoc = null;
		try {
			parserDoc = factoryDoc.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		try {
			parserDoc.parse("src/main/resources/config/config.xml", handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static DefaultHandler handler = new DefaultHandler() {
		
		String lastElement = null;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			lastElement = qName;
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String information = new String(ch, start, length);
			information.replaceAll("\n", "").trim();
			if(lastElement == "user") {
				user = information;
				lastElement = null;
			}
			else if(lastElement == "password") {
				password = information;
				lastElement = null;
			}
			else if(lastElement == "ssl") {
				ssl = information;
				lastElement = null;
			}
		}
	};
}
