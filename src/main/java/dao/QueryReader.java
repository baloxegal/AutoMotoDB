package dao;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class QueryReader {
	
	protected static String sqlFileReader(String nameFile, int i) throws FileNotFoundException, IOException {
				
		BufferedReader buffer = new BufferedReader(new FileReader(Thread.currentThread()
				.getContextClassLoader().getResource("").getPath() + "sql/" + nameFile + ".sql"));
		String inputLine;
		String query = "";
		int j = 0;
		while ((inputLine = buffer.readLine()) != null) {
			if(i == j) {
				query += inputLine;
				break;
			}
			j++;
		}
		buffer.close();
		return query;
	}
}