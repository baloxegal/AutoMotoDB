package db;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

public class SAXParserAtributes {
	
	protected static String user;
	
	public static void xmlSAXParserAtributes() {
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

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			user = attributes.getValue("user");
		}
	};
}
