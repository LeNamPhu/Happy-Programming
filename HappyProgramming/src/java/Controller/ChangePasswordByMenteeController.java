/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DTO.Account;
import DTO.Mentee;
import DTO.Mentor;
import DTO.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordByMenteeController extends HttpServlet {

    private final String ERROR = "ChangePasswordByMentee.jsp";
    private final String SUCCESS = "UserHomePage.jsp";

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
        String url = ERROR;
        UserError userError = new UserError();
        try {
            //PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(true);
            String accountName = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");
            String newPassword = request.getParameter("txtnewpass");
            String confirmPassword = request.getParameter("txtconfirmpass");
            AccountDAO dao = new AccountDAO();
            Account account = dao.checkSignIn(accountName, password);
            boolean check = dao.checkDuplicate(accountName);
            if (account != null) {
                boolean checkValid = true;
                if (check == false) {
                    checkValid = false;
                    userError.setAccError("Incorrect Account name!");
                }
                 if (!newPassword.equals(confirmPassword)) {
                    checkValid = false;
                    userError.setPassError("Password is not the same!!");
                }
                if (checkValid) {
                    boolean updatePass = dao.changePassword(newPassword, accountName);
                    if (updatePass) {
                        url = SUCCESS;
                    }
                }
            } else {
                request.setAttribute("ERROR_MESSAGE", "INCORRECT NAME OR PASSWORD");
            }
        } catch (Exception e) {
            log("Error at ChangePasswordController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
