/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.StudentController;
import Pojos.Student;
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


@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

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

                int studentId = Integer.parseInt(request.getParameter("studentId"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String dob = request.getParameter("dob");
                int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Student obj = new Student(name, address, email, dob, classLevel, status, current_date, userId);

                try {
                    StudentController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            } else if (action.equals("serch")) {

                try {
                    List<Student> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = StudentController.getInstance().Load();

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getStudentId() + "_"
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
            } else if (action.equals("serch_id")) {

                try {
                    List<Student> list = new ArrayList<>();
                    List stringList = new ArrayList<>();
                    int studentId = Integer.parseInt(request.getParameter("studentId"));
                    Student obj = new Student(studentId);
                    list = StudentController.getInstance().LoadbyID(obj);

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getStudentId() + "_"
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

                int studentId = Integer.parseInt(request.getParameter("studentId"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String dob = request.getParameter("dob");
                int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Student obj = new Student(name, address, email, dob, classLevel, status, current_date, userId);
                obj.setStudentId(studentId);

                try {
                    StudentController.getInstance().Update(obj);
                    response.getWriter().println("Update Success");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("delete")) {

                int studentId = Integer.parseInt(request.getParameter("studentId"));

                Student obj = new Student(studentId);

                try {
                    StudentController.getInstance().Delete(obj);
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
