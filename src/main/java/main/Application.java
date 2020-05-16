package main;

import java.sql.SQLException;

import dao.CategoryRepository;
import entities.Category;

public class Application {

	public static void main(String[] args) throws SQLException{
		
		Category testCategoryTen = new Category(5000,"testCS",5L, null);
				
		CategoryRepository catRep = new CategoryRepository();
		
		catRep.create(testCategoryTen);
		
		Category foundCategory = catRep.read(5000);
		System.out.println(foundCategory);
	
	}

}
