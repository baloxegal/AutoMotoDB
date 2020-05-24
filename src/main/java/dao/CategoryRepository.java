package dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.io.IOException;

import entities.Category;
import db.PostgresConnectionManager;

public class CategoryRepository {
	
	public boolean create (Category category) throws SQLException, IOException{

		PreparedStatement pst = null;
		if(category.getParentCategoryId() != null) {
			//pst = PostgresConnectionManager.getConnection().prepareStatement("Insert into categories (id, name, parent_id) values (?,?,?)");
			pst = PostgresConnectionManager.getConnection().prepareStatement(QueryReader.sqlFileReader("create_new_categories"));
			pst.setLong(1, category.getId());
			pst.setString(2, category.getName());
			pst.setLong(3, category.getParentCategoryId());
		}
		else {
			//pst = PostgresConnectionManager.getConnection().prepareStatement("Insert into categories (id, name) values (?,?)");
			pst = PostgresConnectionManager.getConnection().prepareStatement(QueryReader.sqlFileReader("create_new_categories"));
			pst.setLong(1, category.getId());
			pst.setString(2, category.getName());
		}
		return pst.execute();
	}
	
public Category find (long id) throws SQLException, IOException{
	
		Statement st = PostgresConnectionManager.getConnection().createStatement();	
		ResultSet resSet = st.executeQuery("Select * from categories where id = " + id + ";");
		
		Category newCategory = null;
	
		if(resSet.next()) {
			newCategory = new Category();
			newCategory.setId(resSet.getLong("id"));
			newCategory.setName(resSet.getString("name"));
			newCategory.setParentCategoryId(resSet.getLong("parent_id"));
		}
		
		return newCategory;
	}
}
