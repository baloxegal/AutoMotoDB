package main;

import java.io.IOException;
import java.sql.SQLException;

import dao.CategoryRepository;
import entities.Category;

public class Application {

	public static void main(String[] args) throws SQLException, IOException{
		
		Category testCategoryTen = new Category(100000,"testSuper",6L, null);
				
		CategoryRepository catRep = new CategoryRepository();
		
		catRep.create(testCategoryTen);
		
		Category foundCategory = catRep.find(100000);
		System.out.println(foundCategory);
	
	}

}
