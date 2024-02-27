package oumnou.lp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    Database database;


    
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            database = new Database(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    
    }
    
         
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); 
        HttpSession session = request.getSession();
        
      

        if (action.equals("login")) {


            User user = database.getUser(request);
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
               User user =  database.addUser(request);
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


  










