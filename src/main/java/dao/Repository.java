package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.stream.Stream;

import entities.Entity;
import util.ClassReflection;
import util.PostgresConnectionManager;
import util.QueryReader;
import util.TableClassMemberReader;

public abstract class Repository {
	
	private static int Iterator;
	
	@SafeVarargs
	public static <T> Boolean create(String table, T... paramForObject) throws InvalidPropertiesFormatException, FileNotFoundException,
					ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException, NoSuchMethodException, SecurityException, IOException, SQLException{

		Entity entity = ClassReflection.objectForQuery(TableClassMemberReader.xmlTableReader(table), paramForObject);
				
		String queryValues = "";
		
		for(@SuppressWarnings("unused") Object queryArgument : paramForObject) {
			queryValues += "?,";
		}
		
		queryValues = new StringBuffer(queryValues).deleteCharAt(queryValues.lastIndexOf(",")).toString();
		
		
		if(!entity.getClass().getSimpleName().equals("Order")) {
			
			String createQuery = new StringBuffer(QueryReader.sqlFileReader("create_new_entry")).
									insert(12, table).insert(12 + table.length() + 9, queryValues).toString();
			
			PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(createQuery);
			
			Method[] methods = PreparedStatement.class.getMethods();
			
//			int i = 1;

//			for(Object queryArgument : paramForObject) {
//				for(Method method : methods) {
//					if(method.getName().equals("set" + queryArgument.getClass().getSimpleName())) {
//						method.invoke(pst, i++, queryArgument);
//						break;
//					}
//				}
//			}
			
			Iterator = 1;
			
			Stream.of(paramForObject).forEach(queryArgument -> Stream.of(methods).filter(method -> method.getName()
					.equals("set" + queryArgument.getClass().getSimpleName())).findAny().ifPresent(method -> {
						try {
							method.invoke(pst, Iterator++, queryArgument);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}));
			
			pst.execute();
			System.out.println("Operation with Succes!");
			return true;
		}
		else {
			// Create for Orders
		}
		return false;
	}
	
	@SafeVarargs
	public static <T> Boolean delete(String table, T... paramForObject) {
		
		return false;
	}
	
	@SafeVarargs
	public static <T> Boolean findById(String table, T... paramForObject) {
		
		return false;
	}
	
	@SafeVarargs
	public static <T> Boolean findByName(String table, T... paramForObject) {
		
		return false;
	}
	
	@SafeVarargs
	public static <T> Boolean findAll(String table, T... paramForObject) {
		
		return false;
	}
	
	//Update and Select
}