package util;

import entities.Entity;

import java.io.FileNotFoundException;
import java.util.InvalidPropertiesFormatException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ClassReflection {
	
	public static <T> Entity objectForQuery(String nameClass, T[] paramForObject) throws InstantiationException,
				IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
				SecurityException, ClassNotFoundException, InvalidPropertiesFormatException, FileNotFoundException, IOException {
		
		Class<?>[] constructArgs = new Class[paramForObject.length];
	
		for(int i = 0; i < paramForObject.length; i++) {
			constructArgs[i] = paramForObject[i].getClass();
		}
		
		Entity entity = (Entity) Class.forName(nameClass).getConstructor(constructArgs).newInstance(paramForObject);
			
		return entity;
	}
}
