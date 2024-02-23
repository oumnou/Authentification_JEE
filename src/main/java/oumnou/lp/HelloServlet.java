package oumnou.lp;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oumnou.lp.dataBase.Database;
import oumnou.lp.dataBase.DatabaseConnection;
import oumnou.lp.model.User;




@WebServlet(urlPatterns="/servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Connection connection = DatabaseConnection.getConnection();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        Cookie[] cookies = request.getCookies();
     if (cookies != null) {
             for (Cookie cookie : cookies) {
                 if (cookie.getName().equals("loggedIn")) {
                     cookie.setMaxAge(0); 
                     response.addCookie(cookie);
                     response.sendRedirect("index.jsp");


                     break;

                 }
             }
         }
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
            
    // } else if (action.equals("logout")) {
    //     // Remove the loggedIn cookie
    //     Cookie[] cookies = request.getCookies();
    //     if (cookies != null) {
    //         for (Cookie cookie : cookies) {
    //             if (cookie.getName().equals("loggedIn")) {
    //                 cookie.setMaxAge(0); 
    //                 response.addCookie(cookie);

    //                 break;
    //             }
    //         }
    //     }
        
    //     // Invalidate the session
    //     session.invalidate();

    //     // Redirect the user to the login page
    //     response.sendRedirect("index.jsp");
    // }

}
        
    }


  










