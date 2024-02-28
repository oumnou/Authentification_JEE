//package oumnou.lp.dal;
// package oumnou.lp.dataBasee;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;


// public class DatabaseQuery {
//     public static void main(String[] args) {
//         // Obtain database connection
//         try (Connection connection = DatabaseConnection.getConnection()) {
//             if (connection != null) {
//                 System.out.println("Database connection successful!");

//                 // Utilisation de la connexion pour exécuter une requête SQL par exemple
//                 PreparedStatement statement = connection.prepareStatement("INSERT INTO user_accounts(email, password, first_name, last_name, username) VALUES (?,?,?,?,?)");
//                 statement.setString(1, "email");
//                 statement.setString(2, "password");
//                 statement.setString(3, "name");
//                 statement.setString(4, "last_name");
//                 statement.setString(5, "username");
//                 statement.executeUpdate();

//             }
//         } catch (Exception e) {
//            System.out.println("ERROR : " + e.getMessage());
        
//         }
        
    

              
                        
              

                    
//     }}


