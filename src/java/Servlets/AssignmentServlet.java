/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.AssignmentController;
import Pojos.Assignment;
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


@WebServlet(name = "AssignmentServlet", urlPatterns = {"/AssignmentServlet"})
public class AssignmentServlet extends HttpServlet {

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

                int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
                int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                String subject = request.getParameter("subject");
                String topic = request.getParameter("topic");
                String no = request.getParameter("no");
                String note = request.getParameter("note");
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Assignment obj = new Assignment(classLevel, subject, topic, no, null, note, status, current_date, userId);

                try {
                    AssignmentController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            } else if (action.equals("serch")) {

                try {
                    List<Assignment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = AssignmentController.getInstance().Load();

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getAssignmentId() + "_"
                                + list.get(i).getClassLevel() + "_"
                                + list.get(i).getSubject() + "_"
                                + list.get(i).getTopic() + "_"
                                + list.get(i).getNo() + "_"
                                + "Uploaded" + "_"
                                + list.get(i).getNote() + "_"
                                + list.get(i).getDateTime() + "_"
                                + list.get(i).getUserId() + "_";
                        stringList.add(s);
                    }

                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("serch_by_class_level")) {

                try {
                    List<Assignment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();
                    int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                    Assignment obj = new Assignment();
                    obj.setClassLevel(classLevel);
                    list = AssignmentController.getInstance().LoadByClassLevel(obj);

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getAssignmentId() + "_"
                                + list.get(i).getClassLevel() + "_"
                                + list.get(i).getSubject() + "_"
                                + list.get(i).getTopic() + "_"
                                + list.get(i).getNo() + "_"
                                + "Uploaded" + "_"
                                + list.get(i).getNote() + "_"
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

                int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
                int classLevel = Integer.parseInt(request.getParameter("classLevel"));
                String subject = request.getParameter("subject");
                String topic = request.getParameter("topic");
                String no = request.getParameter("no");
                String note = request.getParameter("note");
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Assignment obj = new Assignment(classLevel, subject, topic, no, null, note, status, current_date, userId);
                obj.setAssignmentId(assignmentId);
                try {
                    AssignmentController.getInstance().Update(obj);
                    response.getWriter().println("Update Success");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("delete")) {

                int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));

                Assignment obj = new Assignment();
                obj.setAssignmentId(assignmentId);

                try {
                    AssignmentController.getInstance().Delete(obj);
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
