			
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MySQLConnection;
import model.Food;

public class FoodDAO {
	public List<Food> getAll() {
		List<Food> list = new ArrayList<>();
		String sql = "select * from food";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Food f = new Food(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("price"), rs.getInt("cateId"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Food> searchByName(String key) {
		List<Food> list = new ArrayList<>();
		String sql = "select f.id, f.title, f.price, f.description, f.cid "
				+ " c.cate_name from food f join category c " + "on f.cate_id = c.id where f.title like ?";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, "%" + key + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Food f = new Food(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("price"), rs.getInt("cateId"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
