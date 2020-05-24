package main;

import java.io.IOException;
import java.sql.SQLException;

import dao.CategoryRepository;
import entities.Category;

public class Application {

	public static void main(String[] args) throws SQLException, IOException{
						
		CategoryRepository catRep = new CategoryRepository();
		
		catRep.create(new Category(43,"testForNewSQLFile",null, null));
		
		System.out.println(catRep.find(43));
	
	}

}
