package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchJDBC {

	public static void main(String[] args) {
		Connection connection = Myconnect.getJDBCConnection();
		String sql = "insert into demo(id,name) values(?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "b");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "b");
			preparedStatement.addBatch();
			
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
