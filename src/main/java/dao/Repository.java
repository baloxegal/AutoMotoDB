package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.PostgresConnectionManager;
import entities.Category;

public abstract class Repository {
	
	public static <T> boolean create(String className, T x1, T x2, T x3) throws SQLException, IOException {
		
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
	}

}
