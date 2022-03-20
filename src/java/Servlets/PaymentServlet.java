
package Servlets;

import Controllers.PaymentController;
import Pojos.Payment;
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


@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

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
            

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {

                int paymentId = Integer.parseInt(request.getParameter("paymentId"));
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                String paymentMethod = request.getParameter("paymentMethod");
                double amount = Double.parseDouble(request.getParameter("amount"));
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Payment obj = new Payment(studentId, paymentMethod, amount, status, current_date, userId);

                try {
                    PaymentController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            } else if (action.equals("serch")) {

                try {
                    List<Payment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = PaymentController.getInstance().Load();

                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getPaymentId() + "_"
                                + list.get(i).getStudentId() + "_"
                                + list.get(i).getPaymentMethod() + "_"
                                + list.get(i).getAmount() + "_"
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

                int paymentId = Integer.parseInt(request.getParameter("paymentId"));
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                String paymentMethod = request.getParameter("paymentMethod");
                double amount = Double.parseDouble(request.getParameter("amount"));
                int status = 1;
                int userId = Integer.parseInt(request.getParameter("userId"));

                Payment obj = new Payment(studentId, paymentMethod, amount, status, current_date, userId);
                obj.setPaymentId(paymentId);
                try {
                    PaymentController.getInstance().Update(obj);
                    response.getWriter().println("Update Success");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (action.equals("delete")) {

                int paymentId = Integer.parseInt(request.getParameter("paymentId"));

                Payment obj = new Payment(paymentId);

                try {
                    PaymentController.getInstance().Delete(obj);
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
