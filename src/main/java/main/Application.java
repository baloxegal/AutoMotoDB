package main;

//import dao.CategoryRepository;
//import entities.Category;
import dao.Repository;

import java.io.IOException;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) throws SQLException, IOException{
						
//		CategoryRepository catRep = new CategoryRepository();
//		
//		catRep.create(new Category(44,"testForSQLFile", null));
//		
//		System.out.println(catRep.find(44));
		
		Repository.create("categories", 48, "testSuperAll", null);
	
	}

}
