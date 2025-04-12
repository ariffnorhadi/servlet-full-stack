/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import modelDAO.UserDAO;

/**
 *
 * @author ariffnorhadi
 */
public class UserController extends HttpServlet {

  private UserDAO userDAO;

  @Override
  public void init() {
    try {
      userDAO = new UserDAO(); // What is this UserDAO? Let's go to the file itself to learn more about it (servlet-full-stack\src\java\modelDAO\UserDAO.java)
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet UserController</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    // Remember that we send `action` param to tell servlet what to do with all the params? This is the first thing we want to retrieve
    // so that we know what action to be done with all those attributes.
    // the value of the param is `create_new_user`, after knowing what to do, then we go to the method (createNewUser)
    String action = request.getParameter("action"); // Step 5: retrieve the param, get the value
    //processRequest(request, response);
    switch (action) {
      case "create_new_user" -> // Step 6: create a method to process the params (pass the argument request and response too), so now let's go to the method
        createNewUser(request, response);
      default ->
        processRequest(request, response);
    }
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    // processRequest(request, response);
    String action = request.getParameter("action");

    switch (action) {
      case "login" ->
        validateLogin(request, response);
      default ->
        processRequest(request, response);
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void createNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    // Now we're here.. Let's start doing some backend process
    // Step 7: Retrieve all the params that we need
    String fullName = request.getParameter("full_name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // Step 8 (optional): Put them in an object.
    User newUser = new User();
    newUser.setFullName(fullName);
    newUser.setEmail(email);
    newUser.setPassword(password);

    // Step 9: Insert the data into database using DAO service. This is why initialise the userDAO when initiating this servlet, so that we can use this everywhere.
    // Refer init() method at the top of this file
    userDAO.insertUser(newUser);

    // Usually Create process is a POST action, so we use response.sendRedirect() and send user to any page that we want to. in this case, it's login.jsp
    // Step 10: Redirect to login.jsp
    response.sendRedirect("login.jsp");

    // And we're done with user registration. Congratulations!
  }

  private void validateLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    User user = userDAO.validateLogin(email, password);

    if (user != null) {
      // HttpSession session = request.getSession();
      // session.setAttribute("logged_in_user", user);
      response.sendRedirect("dashboard.jsp");
    } else {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }

}
