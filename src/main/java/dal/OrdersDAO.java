package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import connection.MySQLConnection;
import model.Cart;
import model.Items;
import model.Orders;
import model.Users;

public class OrdersDAO {
	public void addOrder(Users u, Cart cart) {
		LocalDate curDate = java.time.LocalDate.now();
		String date = curDate.toString();
		Connection connection = MySQLConnection.getConnection();
		try {
			String sql = "insert into [order] values(?, ?, ?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, date);
			st.setInt(2, cart.getTotalMoney());
			st.setString(3, "Xac nhan");
			st.setString(4, "Cho them tuong");
			st.setInt(5, u.getId());
			st.executeUpdate();
			String sql1 = "select top 1 id from [order] order by id desc";
			//lấy cái vừa thêm vào, vừa thêm nên id lớn nhất
			PreparedStatement st1 = connection.prepareStatement(sql1);
			ResultSet rs = st1.executeQuery();
			if(rs.next()) {
				int oid = rs.getInt(1);
				for(Items i : cart.getItems()) {
					// thêm các món trong giỏ hàng vào đơn
					String sql2 = "insert into [orderDetail] values (?, ?, ?, ?)";
					PreparedStatement st2 = connection.prepareStatement(sql2);
					st2.setInt(1, oid);
					st2.setInt(2, i.getFood().getId());
					st2.setInt(3, i.getQuantity());
					st2.setDouble(4, i.getPrice());
					st2.executeUpdate();
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Orders> getOrderByStatus(String status) {
		List<Orders> list = new ArrayList<>();
		String sql = "select * from orders where order_status = ? ";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, status);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Orders o = new Orders(rs.getInt("id"), 
									rs.getString("created_date"), 
									rs.getInt("total_money"),
									rs.getString("order_status"),
									rs.getString("note"),
									rs.getInt("user_id"));
				list.add(o);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
