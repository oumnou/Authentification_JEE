package oumnou.lp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import oumnou.lp.dataBasee.Database;
import oumnou.lp.model.User;




@WebServlet(urlPatterns="/servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(lookup = "jdbc/myDB")
    private DataSource dataSource;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
             try {
            // Utilisation de la ressource de données injectée dans la servlet
            try (Connection conn = dataSource.getConnection()) {
                // Utilisation de la connexion pour exécuter une requête SQL par exemple
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_accounts");
                ResultSet rs = stmt.executeQuery();

                // Traitement des résultats de la requête
                while (rs.next()) {
                    // Traiter les résultats de la requête ici
                String result = rs.getString("email"); // Remplacez "nom_colonne" par le nom de la colonne de votre table
                response.getWriter().append("<li>" + result + "</li>");
                }
            }
        } catch (Exception e) {
            response.getWriter().println("Erreur lors de l'accès à la base de données : " + e.getMessage());}
        }
    
         
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); 
        HttpSession session = request.getSession();
        
      

        if (action.equals("login")) {


            User user = Database.getUser(request);
            if (user != null) {
                session.setAttribute("user", user);
                
                Cookie loginCookie = new Cookie("loggedIn", "true");
                loginCookie.setMaxAge(24 * 60 * 60); // Cookie expires in 24 hours
                response.addCookie(loginCookie);

                response.sendRedirect("page2.jsp");

            }else{
                request.setAttribute("invalidInfo", true);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
               
        
                
        } else if (action.equals("signup")) {
               User user =  Database.addUser(request);
               if (user != null) {
                    session.setAttribute("userfromLogin", user);
                    response.sendRedirect("index.jsp");
               }
               else{
                request.setAttribute("emailExist", true);
                request.getRequestDispatcher("signup.jsp").forward(request, response);
               }
          
            }
            

}
        
    }


  










