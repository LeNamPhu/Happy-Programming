/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DTO.Account;
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
 * @author ThienNho
 */
@WebServlet(name = "SignInController", urlPatterns = {"/SignInController"})
public class SignInController extends HttpServlet {

    private final String ERROR = "SignIn.jsp";
    private final String ADMIN = "AdminHomePage.jsp";
    private final String MENTER = "MentorHomePage.jsp";
    private final String MENTEE = "UserHomePage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession(true);
            String acountName = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");
            AccountDAO dao = new AccountDAO();
            Account account = dao.checkSignIn(acountName, password);
            if (account != null) {
                switch (account.getRoleId()) {
                    case 1:
                        url = MENTEE;
                        session.setAttribute("SIGNIN_ACCOUNT", account);
                        session.setAttribute("role", "User");
                        session.setAttribute("signin", "true");
                        break;
                    case 2:
                        url = MENTER;
                        session.setAttribute("SIGNIN_ACCOUNT", account);
                        session.setAttribute("role", "Mentor");
                        session.setAttribute("signin", "true");
                        break;
                    case 3:
                        url = ADMIN;
                        session.setAttribute("SIGNIN_ACCOUNT", account);
                        session.setAttribute("role", "Admin");
                        session.setAttribute("signin", "true");
                        break;
                    default:
                        session.setAttribute("ERROR_MESSAGE", "YOUR ROLE IS NOT SUPPORTED!");
                        break;
                }
            } else {
                request.setAttribute("ERROR_MESSAGE", "INCORRECT EMAIL OR PASSWORD");

            }
        } catch (Exception e) {
            log("Error at SignInController: " + e.toString());
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
