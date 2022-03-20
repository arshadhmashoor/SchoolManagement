/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.AssignmentSubmissionController;
import Pojos.AssignmentSubmission;
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


@WebServlet(name = "AssignmentSubmissionServlet", urlPatterns = {"/AssignmentSubmissionServlet"})
public class AssignmentSubmissionServlet extends HttpServlet {

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

                int assignmentSubmissionId = Integer.parseInt(request.getParameter("assignmentSubmissionId"));
                String subject = request.getParameter("subject");
                String topic = request.getParameter("topic");
                String no = request.getParameter("no");
                String note = request.getParameter("note");
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                AssignmentSubmission obj = new AssignmentSubmission(subject, topic, no, null, note, status, current_date, userId);

                try {
                    AssignmentSubmissionController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            } else if (action.equals("serch")) {

                try {
                    List<AssignmentSubmission> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = AssignmentSubmissionController.getInstance().Load();

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getAssignmentSubmissionId()+ "_"
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

                int assignmentSubmissionId = Integer.parseInt(request.getParameter("assignmentSubmissionId"));
                String subject = request.getParameter("subject");
                String topic = request.getParameter("topic");
                String no = request.getParameter("no");
                String note = request.getParameter("note");
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                AssignmentSubmission obj = new AssignmentSubmission(subject, topic, no, null, note, status, current_date, userId);
                obj.setAssignmentSubmissionId(assignmentSubmissionId);
                try {
                    AssignmentSubmissionController.getInstance().Update(obj);
                    response.getWriter().println("Update Success");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("delete")) {

                int assignmentSubmissionId = Integer.parseInt(request.getParameter("assignmentSubmissionId"));

                AssignmentSubmission obj = new AssignmentSubmission();
                obj.setAssignmentSubmissionId(assignmentSubmissionId);

                try {
                    AssignmentSubmissionController.getInstance().Delete(obj);
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
