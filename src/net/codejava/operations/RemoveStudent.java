package net.codejava.operations;
import java.sql.*;

import net.codejava.utils.Database;
public class RemoveStudent {
	Database db = new Database();
	Connection conn = db.getConnection();
	private int id;
	
	public RemoveStudent(int id){
		this.id = id;
	}
	
	public void removeStd() {
		if (conn != null) {
			try(Statement stmt = conn.createStatement()){
				String sql = "DELETE FROM student WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, this.id);
				
				int result = pstmt.executeUpdate();
				if(result > 0) {					
					System.out.println("Successfull Deleted this userId " + this.id);
				}else {					
					System.out.println("Student not found!");
				}
			}catch(SQLException e) {
				System.out.println("Error deleting this userId" + this.id);
			}
		}
	}
}
