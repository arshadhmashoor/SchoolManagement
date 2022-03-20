/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.TeacherController;
import Pojos.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TeacherServlet", urlPatterns = {"/TeacherServlet"})
public class TeacherServlet extends HttpServlet {

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
            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {

                int teacherId = Integer.parseInt(request.getParameter("teacherId"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String dob = request.getParameter("dob");
                int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Teacher obj = new Teacher(name, address, email, dob, classLevel, status, current_date, userId);

                try {
                    TeacherController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            } else if (action.equals("serch")) {

                try {
                    List<Teacher> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = TeacherController.getInstance().Load();

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getTeacherId() + "_"
                                + list.get(i).getName() + "_"
                                + list.get(i).getAddress() + "_"
                                + list.get(i).getEmail() + "_"
                                + list.get(i).getDob() + "_"
                                + list.get(i).getClassLevel() + "_"
                                + list.get(i).getDateTime() + "_"
                                + list.get(i).getUserId() + "_";
                        stringList.add(s);
                    }

                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("update")) {

                int teacherId = Integer.parseInt(request.getParameter("teacherId"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String dob = request.getParameter("dob");
                int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Teacher obj = new Teacher(name, address, email, dob, classLevel, status, current_date, userId);
                obj.setTeacherId(teacherId);

                try {
                    TeacherController.getInstance().Update(obj);
                    response.getWriter().println("Update Success");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("delete")) {

                int teacherId = Integer.parseInt(request.getParameter("teacherId"));

                Teacher obj = new Teacher(teacherId);

                try {
                    TeacherController.getInstance().Delete(obj);
                    response.getWriter().println("Delete Success");
                } catch (Exception ex) {
                    System.out.println(ex);
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
