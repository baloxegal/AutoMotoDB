package main;

import dao.Repository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException,
							NoSuchMethodException, SecurityException, InstantiationException,
							IllegalAccessException,	IllegalArgumentException, InvocationTargetException{
						
		Repository.create("categories", 100L, "testOlimp", 45L);
	}
}
