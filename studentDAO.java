/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbms_task2;


import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {
 
      public static boolean insertstu(int usn, String name, int sem,String sec) {
        try (Connection connection = DB.getConnection()) {
            String query = "INSERT INTO student(usn,name,sem,sec) VALUES (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
statement.setInt(1, usn);
statement.setString(2, name);
statement.setInt(3, sem); // Assuming 'author' is a string
statement.setString(4, sec);


            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}