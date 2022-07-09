/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InviteDAO;
import DAO.RateDAO;
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
@WebServlet(name = "StatisticByMentorController", urlPatterns = {"/StatisticByMentorController"})
public class StatisticByMentorController extends HttpServlet {
   private final String ERROR = "Error.jsp";
    private final String SUCCESS = "StatisticByMentor.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int userId = user.getId();
            InviteDAO dao = new InviteDAO();
            int accReq = dao.getCountReq(userId, "Accepted");
            int rejReq = dao.getCountReq(userId, "Rejected");
            int invReq = dao.getCountReq(userId, "Pending");
            int sum = accReq + rejReq + invReq;
            double perAcc = accReq * 100 / sum ;
            double perRej = rejReq * 100 / sum;
            RateDAO rateDAO = new RateDAO();
            double star = rateDAO.getStar(userId);
            String a = String.valueOf(accReq);
            String b = String.valueOf(rejReq);
            String c = String.valueOf(invReq);
            String d = String.valueOf(perAcc);
            String e = String.valueOf(perRej);
            String f = String.valueOf(star);
            
            request.setAttribute("ACCEPTED_REQ", a);
            request.setAttribute("REJECTED_REQ", b);
            request.setAttribute("INVITING_REQ", c);
            request.setAttribute("PERCENT_ACC", d);
            request.setAttribute("PERCENT_REJ", e);
            request.setAttribute("STAR", f);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at StatisticByMentorController" + e.toString());
        }finally{
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
