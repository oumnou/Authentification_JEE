package oumnou.lp;

import java.io.IOException;

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
    
         
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); 
        HttpSession session = request.getSession();
        
        // Ensure database object is initialized
        if (database == null) {
            try {
                database = new Database(dataSource.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }
        }
        switch (action) {
            case "login":
                User userLogin = database.getUser(request);
                if (userLogin != null) {
                    session.setAttribute("user", userLogin);
                    
                    Cookie loginCookie = new Cookie("loggedIn", "true");
                    loginCookie.setMaxAge(24 * 60 * 60); // Cookie expires in 24 hours
                    response.addCookie(loginCookie);
        
                    response.sendRedirect("page2.jsp");
                } else {
                    request.setAttribute("invalidInfo", true);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
                
            case "signup":
                try {
                    database = new Database(dataSource.getConnection());
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                User userSignup =  database.addUser(request);
                if (userSignup != null) {
                    session.setAttribute("userfromLogin", userSignup);
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("emailExist", true);
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
                break;
        }
    }}        