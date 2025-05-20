package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class config {

    private Connection connect;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/binsbites";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    public static String loggedInUsername; // keeps email
    public static int loggedInUserId;   

   
    public config() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/binsbites", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }


    //Function to save data
    public int insertData(String sql) {
        int result;
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            pst.close();
            result = 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            result = 0;
        }
        return result;
    }

    //Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        return rst;
    }

     public static Connection getConnection() {
        Connection conn = null;
        try {
            // Replace with your actual database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/binsbites";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
