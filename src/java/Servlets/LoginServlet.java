/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.UserSignInController;
import Models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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

            String user = request.getParameter("username");
            String pass = request.getParameter("password");

            if (user.contains("'") || pass.contains("'") || user.contains(";") || pass.contains(";")) {
                response.sendRedirect("index.jsp");
            } else {

                UserModel um = UserModel.getInstance();
                um.setUsername(user);
                um.setPassword(pass);

                if (UserSignInController.getInstance().userSignIn()) {

                    HttpSession session = request.getSession();
                    session.setAttribute("userid", um.getLoggedUserId());
                    session.setAttribute("userfullname", um.getLoggedUserFullName());
                    session.setAttribute("classlevel", um.getClassLevel());
                    session.setAttribute("usertype", um.getLoggedUserType());
                    session.setAttribute("studentId", um.getStudent_id());

                    if (um.getLoggedUserType().equals("admin")) {
                        response.sendRedirect("admin.jsp");
                    } else if (um.getLoggedUserType().equals("student")) {
                        response.sendRedirect("student_home.jsp");

                    }

                } else {
                    response.sendRedirect("student_login.jsp");
                }
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
