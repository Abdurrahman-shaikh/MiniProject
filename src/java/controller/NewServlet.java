package controller;

import model.RegisterDB;
import model.LoginDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            if (action != null && action.equals("register")) {
                handleRegistration(request, out);
            } else if (action != null && action.equals("login")) {
                handleLogin(request, out);
            }
        }
    }

    private void handleRegistration(HttpServletRequest request, PrintWriter out)
            throws ParseException, ClassNotFoundException {
        int gender = getGender(request).orElse(0);
        RegisterDB user = createUserFromRequest(request, gender);
        user.insertUserData();
        out.println(user.isAffected() > 0 ? "Data inserted successfully" : "Data insertion failed");
    }

    private Optional<Integer> getGender(HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter("gender"))
                .map(genderStr -> genderStr.equals("male") ? 1 : 2);
    }

    private RegisterDB createUserFromRequest(HttpServletRequest request, int gender) {
        RegisterDB user = new RegisterDB();
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setDob(request.getParameter("dob"));
        user.setMobileno(request.getParameter("mobileno"));
        user.setEmail(request.getParameter("email"));
        user.setGender(gender);
        return user;
    }

    private void handleLogin(HttpServletRequest request, PrintWriter out)
            throws ClassNotFoundException {
        String email = request.getParameter("myemail");
        String password = request.getParameter("mypassword");
        
        if (email != null && password != null) {
            LoginDB login = new LoginDB();
            login.setMyEmail(email);
            login.setPassword(password);
            login.login();
            out.println(login.isAuthenticated() ? "Login successful" : "Login failed");
        } else {
            out.println("Email and password are required for login.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Form Submission Servlet";
    }
}
