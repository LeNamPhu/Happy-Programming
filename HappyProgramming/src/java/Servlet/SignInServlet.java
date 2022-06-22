/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.AccountDAO;
import DTO.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "signInServlet", urlPatterns = {"/signInServlet"})
public class SignInServlet extends HttpServlet {

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
            String email = request.getParameter("txtemail");
            String pass = request.getParameter("txtpass");
            Account acc = null;
            try {
                if (email == null || email.equals("") || pass == null || pass.equals("")) {
                    Cookie[] c = request.getCookies();
                    String token = "";
                    if (c != null) {
                        for (Cookie aCookie : c) {
                            if (aCookie.getName().equals("selector")) {
                                token = aCookie.getValue();
                            }
                        }
                    }
                    if (!token.equals("")) {
                        response.sendRedirect("HomePage.jsp");
                    } else {
                        response.sendRedirect("Error.jsp");
                    }
                } else {
                    acc = AccountDAO.getAccount(email, pass);
                    if (acc != null) {
                        switch (acc.getRoleId()) {
                            case 3: {
                                // Admin Home Page
                                HttpSession session = request.getSession(true);
                                if (session != null) {
                                    session.setAttribute("name", acc.getAccountName());
                                    session.setAttribute("email", email);
                                    session.setAttribute("role", acc.getRoleId());
                                    response.sendRedirect("AdminHomePage.jsp");
                                }
                                break;
                            }
                            case 2: {
                                // Admin Home Page
                                HttpSession session = request.getSession(true);
                                if (session != null) {
                                    session.setAttribute("name", acc.getAccountName());
                                    session.setAttribute("email", email);
                                    session.setAttribute("role", acc.getRoleId());
                                    response.sendRedirect("MentorHomePage.jsp");
                                }
                                break;
                            }
                            default: {
                                HttpSession session = request.getSession(true);
                                if (session != null) {
                                    session.setAttribute("name", acc.getAccountName());
                                    session.setAttribute("email", email);
                                    session.setAttribute("role", acc.getRoleId());
                                    response.sendRedirect("UserHomePage.jsp");
                                }
                                break;
                            }
                        }
                    } else {
                        request.setAttribute("WARNING", "invalid name or password");
                        request.getRequestDispatcher("SignIn.jsp").forward(request, response);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
