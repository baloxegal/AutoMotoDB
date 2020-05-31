package util;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class QueryReader {
	
	public static String sqlFileReader(String nameFile) throws FileNotFoundException, IOException {
				
		BufferedReader buffer = new BufferedReader(new FileReader(Thread.currentThread()
				.getContextClassLoader().getResource("").getPath() + "sql/" + nameFile + ".sql"));
		String inputLine;
		String query = "";
		while ((inputLine = buffer.readLine()) != null) {
			query += inputLine;
		}
		buffer.close();
		return query;
	}
}