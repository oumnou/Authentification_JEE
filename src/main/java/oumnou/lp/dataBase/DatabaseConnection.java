package oumnou.lp.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements Config {

    public static Connection getConnection() throws SQLException {
        String url = URL; 
        String username = USER;
        String password = PASSWO;
        
        return DriverManager.getConnection(url, username, password);
    }
}
