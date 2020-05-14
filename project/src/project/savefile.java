package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class savefile {
	//private String filePath = "/home/minh/Documents/data.txt";
	
	public static void main(String[] args) {
		
		
		
		File file = new File("text.txt");
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
				
			Connection connection = Myconnect.getJDBCConnection();
			
			String sql = "insert into file(name, file) values(?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setString(1,"text.txt");
			preparedStatement.setBinaryStream(2, fileInputStream);
			preparedStatement.executeUpdate();
			
			System.out.println("success file");
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		
	}
}
