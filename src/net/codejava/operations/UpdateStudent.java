package net.codejava.operations;
import java.sql.*;

import net.codejava.utils.Database;
public class UpdateStudent {
	Database db = new Database();
	Connection conn = db.getConnection();
	private int id;
	private String name;
	private Double gwa;
	
	public UpdateStudent (int id, String name, Double gwa){
		this.id = id;
		this.name = name;
		this.gwa = gwa;
	}
	
	public void updateStudent() {
		if(conn != null) {
			try(Statement stmt = conn.createStatement()){
				String sql = "UPDATE student SET name = ?, gwa = ? WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, this.name);
				pstmt.setDouble(2, this.gwa);
				pstmt.setInt(3, this.id);
				int rs = pstmt.executeUpdate();
				if(rs > 0) {
					System.out.println("Successfull Updated with Student ID " + this.id);
				}else {
					System.out.println("Student ID not Found!");
				}
			}catch(SQLException e) {
				System.out.println("Failed to updated");
			}
		}
	}
}
