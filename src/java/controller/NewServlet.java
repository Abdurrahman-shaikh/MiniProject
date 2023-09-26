package controller;

import model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet to handle form submissions.
 */
public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String mobileNo = request.getParameter("mobileno");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            int gen = 0;
            if(gender.equals("male")) {
                gen = 1;
            }else{
                gen = 2;
            }

            MyDb user = new MyDb();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDob(dob);
            user.setMobileno(mobileNo);
            user.setEmail(email);
            user.setGender(gen);
            user.insertUserData();
            
            int effect = user.isAffected();
            out.println(effect);
            
            if (effect > 0) {
                System.out.println("Data inserted successfully into user_table");
            } else {
                System.out.println("Data insertion into user_table failed");
            }
            
            
            
            
            
//            if ("true".equals(cancelRequest)) {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/cancle");
//                dispatcher.forward(request, response);
//            } else {
//                Student student = new Student("Azmi");
//                student.setName("Azmi");
//                String name = student.getName();
//                request.setAttribute("name", name);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/res");
//                dispatcher.forward(request, response);
//            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
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
        }
    }

    @Override
    public String getServletInfo() {
        return "Form Submission Servlet";
    }
}
