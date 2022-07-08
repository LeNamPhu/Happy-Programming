/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DTO.Account;
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
@WebServlet(name = "ChangePasswordMentorController", urlPatterns = {"/ChangePasswordMentorController"})
public class ChangePasswordByMentorController extends HttpServlet {

    private final String ERROR = "ChangePasswordByMentor.jsp";
    private final String SUCCESS = "MentorHomePage.jsp";

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
            String accountName = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");
            String newPassword = request.getParameter("txtnewpass");
            String confirmPassword = request.getParameter("txtconfirmpass");
            AccountDAO dao = new AccountDAO();
            Account account = dao.checkSignIn(accountName, password);
            if (account != null) {
                boolean check = dao.checkDuplicate(accountName);
                boolean checkValid = true;

                if (check == false) {
                    checkValid = false;
                    userError.setAccError("Incorrect Account name!");
                    request.setAttribute("ERROR_MESSAGE", "Incorrect Account name!");
                } else if (!newPassword.equals(confirmPassword)) {
                    checkValid = false;
                    userError.setPassError("Password is not the same!!");
                    request.setAttribute("ERROR_MESSAGE", "Password is not the same!!");
                } else if (checkValid == true) {
                    boolean updatePass = dao.changePassword(newPassword, accountName);
                    if (updatePass == true) {
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
