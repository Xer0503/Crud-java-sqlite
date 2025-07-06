package net.codejava.utils;
import java.sql.*;

public class Database {
    private final String jdbcUrl = "jdbc:sqlite:C:/Users/admin/Desktop/Java/Array/sqlite3/sqlTool/student.db"; 
    // Reusable method to get the connection
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
