package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Category;
import db.PostgresConnectionManager;

public class CategoryRepository {
	
	public boolean create (Category category) throws SQLException{
		
//		Statement st = connect().createStatement();	
//		st.executeUpdate("Insert into categories (id, name, parent_id) values ("+ category.getId() + ",'" + category.getName()
//		+ "'," + category.getParentCategoryId() + ")");
		
		PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement("Insert into categories (id, name, parent_id) values (?,?,?)");
		pst.setLong(1, category.getId());
		pst.setString(2, category.getName());
		if(category.getParentCategoryId() != null) pst.setLong(3, category.getParentCategoryId());
		return pst.execute();
	}
	
public Category find (long id) throws SQLException{
	
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
