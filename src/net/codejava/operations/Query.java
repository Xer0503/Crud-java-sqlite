package net.codejava.operations;
import java.sql.*;

import net.codejava.utils.Color;
import net.codejava.utils.Database;
public class Query extends Database{
	Database db = new Database();
	Connection conn = db.getConnection();
	Color c = new Color();
	public void viewStudent(){
        try(Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("-------------------------------------------");
            System.out.printf( "%-4s %-20s %-6s %-10s\n", "ID", "Name", "GWA", "Remarks");
            System.out.println("-------------------------------------------");
            while (rs.next()) {
            	String rmColored = rs.getDouble("gwa") <= 3.0 ? c.green() + "Passed" + c.reset():
            				c.red() + "Failed" + c.reset();
                System.out.printf( "%-4s %-20s %-6s %-10s\n",
                		rs.getInt("id") , rs.getString("name"), rs.getDouble("gwa"), rmColored);}
            System.out.println("-------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
