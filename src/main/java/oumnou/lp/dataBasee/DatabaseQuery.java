package oumnou.lp.dataBasee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseQuery {

    public static void main(String[] args) {
    
        // Obtain database connection
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Database connection successful!");


                //String query = "INSERT INTO user_accounts (email, password, first_name, last_name, username) VALUES (?, ?, ?, ?, ?)";
                String deleteString = "DELETE FROM user_accounts ";
                // PreparedStatement statement = connection.prepareStatement(query);
                //     statement.setString(1, "oumaima.nou@example.com");
                //     statement.setString(2, "hello123");
                //     statement.setString(3, "Oumaima");
                //     statement.setString(4, "Nouini");
                //     statement.setString(5, "Oumnou");
        
                 //     int rowsInserted = statement.executeUpdate();



               
                     PreparedStatement statement2 = connection.prepareStatement(deleteString);
                       
                        
                    statement2.executeQuery() ;
                    System.out.println("finished");

                    
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }}



