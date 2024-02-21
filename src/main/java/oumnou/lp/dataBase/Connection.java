package oumnou.lp.dataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {

    public static void main(String[] args) throws SQLException {
       
            Connection connection;
            connection = (Connection) DatabaseConnection.getConnection();
        
            
            // Example: execute a query
            PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement("SELECT * FROM user_accounts");
            ResultSet resultSet = statement.executeQuery();
           
           
}
}

