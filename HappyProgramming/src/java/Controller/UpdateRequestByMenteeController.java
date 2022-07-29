/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RequestDAO;
import DTO.Account;
import DTO.Request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "UpdateRequestByMenteeController", urlPatterns = {"/UpdateRequestByMenteeController"})
public class UpdateRequestByMenteeController extends HttpServlet {

    private final String ERROR = "Error.jsp";
    private final String SUCCESS = "ListRequestByMenteeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession(true);
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int menteeID = user.getId();
            int reqID = Integer.parseInt(request.getParameter("reqIDForUpdate"));
            String title = request.getParameter("title");
            String status = request.getParameter("status");        
            
            java.sql.Date deadlineDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deadlineDate")).getTime());
                    
            int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
            String content = request.getParameter("content");           
            Request req = new Request(reqID, title, status, content, menteeID, deadlineDate, deadlineHour);            
            String skill1 = request.getParameter("skill1");
            String skill2 = request.getParameter("skill2");
            String skill3 = request.getParameter("skill3");           
            RequestDAO dao = new RequestDAO();
            dao.updateReq(req);
            dao.updateSkillReq(reqID, skill1, skill2, skill3);          
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at UpdateRequestByMenteeController:" + e.toString());
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
