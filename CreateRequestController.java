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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trida
 */
@WebServlet(name = "CreateRequestController", urlPatterns = {"/CreateRequestController"})
public class CreateRequestController extends HttpServlet {
    private final String ERROR = "Error.jsp";
    private final String SUCCESS = "CreateRequest.jsp";
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
        try {
            HttpSession session = request.getSession(true);
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
             String title = request.getParameter("title");
             String status = "Open";
             String content = request.getParameter("content");
             int menteeID = user.getId();
             Date deadlineDate = Date.valueOf(request.getParameter("deadlineDate"));
             int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
            
             boolean valid = true;
             Request req = new Request(0, title, status, content, menteeID, deadlineDate, deadlineHour);
             RequestDAO reqdao = new RequestDAO();
             boolean checkinsert = reqdao.insertREQ(req);
             if(checkinsert){
                 url = SUCCESS;
             }
             
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
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
