package oumnou.lp.dataBasee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;

public class DatabaseQuery {
    @Resource(lookup = "jdbc/myDB")
    static DataSource dataSource;


    public static void main(String[] args) throws SQLException {
              try {
            // Utilisation de la ressource de données injectée dans la servlet
            try (Connection conn = dataSource.getConnection()) {
                // Utilisation de la connexion pour exécuter une requête SQL par exemple
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_accounts");
                ResultSet rs = stmt.executeQuery();

                // Traitement des résultats de la requête
                while (rs.next()) {
                    // Traiter les résultats de la requête ici
                System.out.println(rs.getString("email"));
                }
            }
        } catch (Exception e) {
           System.out.println("ERROR : " + e.getMessage());
        
        }
        
    

              
                        
              

                    
    }}


