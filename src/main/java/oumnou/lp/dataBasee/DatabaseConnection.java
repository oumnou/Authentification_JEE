package oumnou.lp.dataBasee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements Config {
    private static Connection connexion;

    public static Connection getConnection(){

    if(connexion == null) {
       
        try {
            connexion = DriverManager.getConnection(URL, USER,PASSWO );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return connexion;
}
}
