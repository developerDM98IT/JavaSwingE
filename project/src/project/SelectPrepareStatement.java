package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPrepareStatement {
	public static void main(String[] args) {
		Connection connection = Myconnect.getJDBCConnection();
		
		String sql = "select * from demo where id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,1);//(index of id, index of name)
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + rs.getString("name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
