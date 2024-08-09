/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbms_task2;

/**
 *
 * @author SAHANA
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginLAO {
     public static boolean validate(String enteredUsername, String enteredPassword) {
        try (Connection connection = DB.getConnection()) {
            String query = "SELECT password FROM users WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, enteredUsername);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String storedPassword = result.getString("password");
               if (storedPassword.equals(enteredPassword)) {
                    return true; // Passwords match
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Return false if validation fails
    }

}