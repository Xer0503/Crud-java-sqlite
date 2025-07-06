package net.codejava.operations;
import java.sql.*;

import net.codejava.utils.Database;
public class AddStudent {
	Database db = new Database();
	Connection conn = db.getConnection();
	
	private String name;
	private Double gwa;
	
	public AddStudent(String name, Double gwa){
		this.name = name;
		this.gwa = gwa;
	}
	
	public void addStudent() {
		if(conn != null) 
			{
				try(Statement stmt = conn.createStatement()){
					String sql = "INSERT INTO student (name, gwa) VALUES (?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, this.name);
	                pstmt.setDouble(2, this.gwa);
	                pstmt.executeUpdate();
	                System.out.println("Add Student Successfull");
				}catch(SQLException e) {
					System.out.println("Failed to add Student");
				}
			}
		}
}
