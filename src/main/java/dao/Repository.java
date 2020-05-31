package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

import entities.Entity;
import util.ClassReflection;
import util.PostgresConnectionManager;
import util.QueryReader;
import util.TableClassMemberReader;

public abstract class Repository {
	
	@SafeVarargs
	public static <T> Boolean create(String table, T... paramForObject) throws InvalidPropertiesFormatException, FileNotFoundException,
					ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException, NoSuchMethodException, SecurityException, IOException, SQLException{

		Entity entity = ClassReflection.objectForQuery(TableClassMemberReader.xmlTableReader(table), paramForObject);
		
		
		
		String queryValues1 = "";
		
		for(@SuppressWarnings("unused") Object queryArgument : paramForObject) {
			queryValues1 += "?,";
		}
		
		String queryValues = new StringBuffer(queryValues1).deleteCharAt(queryValues1.lastIndexOf(",")).toString();
		
		
		if(!entity.getClass().getSimpleName().equals("Order")) {
			
			String createQuery = new StringBuffer(QueryReader.sqlFileReader("create_new_entry")).
									insert(12, table).insert(12 + table.length() + 9, queryValues).toString();
			
			PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(createQuery);
			System.out.println(createQuery);
			Method[] methods = PreparedStatement.class.getMethods();
			
			int i = 1;
			for(Object queryArgument : paramForObject) {
				for(Method method : methods) {
					if(method.getName().equals("set" + queryArgument.getClass().getSimpleName())) {
						method.invoke(pst, i, queryArgument);
						i++;
						break;
					}
				}
			}
			
			pst.execute();
			return true;
		}
		else {
			
		}

		return false;
	}
}


