package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import connection.MySQLConnection;
import model.Category;

public class CategoryDAO {
	public List<Category> getAll(){
		List<Category> list = new ArrayList<>();
		String sql = "select * from Category";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setCateName(rs.getString("cate_name"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
