package dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import model.Users;

public class RegisterDAO {
	public static boolean InsertAccount(Connection conn, Users users) {
		LocalDate curDate = java.time.LocalDate.now();
		PreparedStatement ptmt = null;
		String date = curDate.toString();
		String sql = "INSERT INTO users(fullname, username, password, email, address, phone_number, created_date, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try
		{
			ptmt = conn.prepareStatement(sql);
			String fullname = users.getFullname();
			String username = users.getUsername();
			String password = users.getPassword();
			String email = users.getEmail();
			String address = users.getAddress();
			String phone_number = users.getPhoneNumber();
			ptmt.setString(1, fullname);
			ptmt.setString(2, username);
			ptmt.setString(3, password);
			ptmt.setString(4, email);
			ptmt.setString(5, address);
			ptmt.setString(6, phone_number);
			ptmt.setString(7, date);
			ptmt.setInt(8, 2);
			int check = ptmt.executeUpdate();
			if(check != 0)
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
