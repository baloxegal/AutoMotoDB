package main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import dao.Repository;

public class Application {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException,
							NoSuchMethodException, SecurityException, InstantiationException,
							IllegalAccessException,	IllegalArgumentException, InvocationTargetException{
						
		Repository.create("categories",5958l, "Calipso", 1000l);
	}
}
