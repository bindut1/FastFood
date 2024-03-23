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
	public List<Food> getAll(){
		List<Food> list = new ArrayList<>();
		String sql = "select * from food";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Food f = new Food(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("price"), rs.getInt("cate_id"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> searchByName(String key){
		List<Food> list = new ArrayList<>();
		String sql = "select f.id, f.title, f.price, f.description, f.cid "
				+ " c.cate_name from food f join category c "
				+"on f.cate_id = c.id where f.title like ?";;
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, "%" + key + "%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Food f = new Food(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("price"), rs.getInt("cate_id"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Food> getByCatID(int id){
		List<Food> list = new ArrayList<>();
		String sql = "select f.id, f.title, f.price, f.description, f.cid "
				+ " c.cate_name from food f join category c "
				+"on f.cate_id = c.id where c.id = ?";;
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Food f = new Food(
						rs.getInt("id"), 
						rs.getString("title"),
						rs.getString("description"), 
						rs.getInt("price"), 
						rs.getInt("cate_id"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Food getFoodById(int id) {
		String sql = "select * from food where id = ?";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return  new Food(
						rs.getInt("id"), 
						rs.getString("title"),
						rs.getString("description"), 
						rs.getInt("price"), 
						rs.getInt("cate_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Food> getListByPage(List<Food> list, int start, int end){
		ArrayList<Food> arr = new ArrayList<>();
		for(int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}
	
	public int deleteFoodById(int id) {
		Connection connection = MySQLConnection.getConnection();
		String sql = "delete from food f where f.id = ?";
		int isDelete = 0;
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			
			isDelete = st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isDelete;
	}
	
	public int insertFood(String title, String desc, int price, int cateId) {
		Connection connection = MySQLConnection.getConnection();
		String sql = "insert into food(title, description, price, cate_id) values (?, ?, ?, ?)";
		int isSuccess = 0 ;
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, desc);
			st.setInt(3, price);
			st.setInt(4, cateId);
			isSuccess = st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
