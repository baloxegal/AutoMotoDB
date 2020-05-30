package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.InvalidPropertiesFormatException;

import entities.Category;
import entities.Entity;
import util.ClassReflection;
import util.TableClassMemberReader;

public abstract class Repository {
	
	@SafeVarargs
	public static <T> Entity create(String table, T... paramForObject) throws InvalidPropertiesFormatException, FileNotFoundException,
					ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException, NoSuchMethodException, SecurityException, IOException{

		Entity ps = ClassReflection.objectForQuery(TableClassMemberReader.xmlTableReader(table), paramForObject);
		
		
		
		System.out.println(ps.getId());
		System.out.println(((Category)ps).getName());
		System.out.println(ps.getTable());
		System.out.println(((Category)ps).getParentCategoryId());
		return ps;
	}
}


