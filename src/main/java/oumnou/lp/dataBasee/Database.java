package oumnou.lp.dataBasee;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

import oumnou.lp.model.User;

public class Database {
    
    static final Connection connection = DatabaseConnection.getConnection();

     public static User getUser(HttpServletRequest request)  {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String query = "SELECT * FROM user_accounts where email = ? AND password = ?";

      
        try {
            

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery() ;

                if (resultSet.next()) {
                   return new User(
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("FIRST_NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getString("username"));
                }
            
               
        } catch (Exception e) {
           
          return null;

        }
        return null;
    }
    public static User addUser(HttpServletRequest request)   {
        String query = "INSERT INTO user_accounts (email, password, first_name, last_name, username) VALUES (?, ?, ?, ?, ?)";
        
        String email = request.getParameter("email");
        try {
            if (emailExists(email)) {
                return null;
            }
            else{


            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String last_name = request.getParameter("last_name");
            String username = request.getParameter("username");

            
            

            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, password);
                statement.setString(3, name);
                statement.setString(4, last_name);
                statement.setString(5, username);

                statement.executeUpdate();
                return new User(
                    email,
                    password,
                    name,
                    last_name,
                    username);

   }
        } catch (SQLException e) {
            return null;

        }
      
}    
    static boolean emailExists(String email) throws SQLException {
        String query = "SELECT * FROM user_accounts where email = ?";
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery() ;

        if (resultSet.next()) {
            return true;
        }

        return false;
    }

}