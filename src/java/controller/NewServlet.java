package controller;

import model.RegisterDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LoginDB;

/**
 * Servlet to handle form submissions.
 */
public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String mobileNo = request.getParameter("mobileno");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            int gen = 0;
            if(gender.equals("male")) gen = 1;
            else gen = 2;
            
            RegisterDB user = new RegisterDB();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDob(dob);
            user.setMobileno(mobileNo);
            user.setEmail(email);
            user.setGender(gen);
            user.insertUserData();
            
            int effect = user.isAffected();            
            if (effect > 0) {
                out.println("Data inserted successfully into user_table");
            } else {
                out.println("Data insertion into user_table failed");
            }
                String myEmail = request.getParameter("myemail");
                String myPassword = request.getParameter("mypassword");
                String action = request.getParameter("login");
            if (action != null && action.equals("login")) {
                LoginDB login = new LoginDB();
                login.setMyEmail(myEmail);
                login.setPassword(myPassword);
                login.login();
                boolean isAuthenticated = login.isAuthenticated();
                if (isAuthenticated) out.println("Login successful for user: ");
                else out.println("Login failed");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Form Submission Servlet";
    }
}
