package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MySQLConnection;
import model.Users;

public class UsersDAO {
	public Users getAccount(String username, String password) {
		String sql = "select * from users where username = ? and password = ?";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				return new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getInt(9) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
