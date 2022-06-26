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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "ListInviteController", urlPatterns = {"/ListInviteController"})
public class ListInviteController extends HttpServlet {

    private final String ERROR = "Error.jsp";
    private final String SUCCESS = "ListInviteRequest.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int id = 3;
            RequestDAO dao = new RequestDAO();
             ArrayList<Request> listInvite = dao.getListInviteRequest(dao.getListInviteRequestID(id));
            session.setAttribute("LIST_INVITE", listInvite);
             Map<Request, String> map = new HashMap<>();
             for (Request a : listInvite){
                ArrayList<Integer> listIDSkillReq = dao.getIDSkillReq(a);
                dao.getNameSkillReq(listIDSkillReq, a, map);
            }
             session.setAttribute("SKILL_INVITE_REQUEST", map);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at DeleteRequestByMenteeController " + e.toString());
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
