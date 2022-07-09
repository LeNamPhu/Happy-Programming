/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DAO.InviteDAO;
import DAO.MentorDAO;
import DAO.RequestDAO;
import DTO.Mentor;
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
@WebServlet(name = "SuggestionMentorController", urlPatterns = {"/SuggestionMentorController"})
public class SuggestionMentorController extends HttpServlet {

    private final String ERROR = "Error.jsp";
    private final String SUCCESS = "SuggestionMentor.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            
            int reqID = Integer.parseInt(request.getParameter("reqID"));
            RequestDAO reqDAO = new RequestDAO();
            ArrayList<Integer> reqSkill = reqDAO.getSkillReq(reqID);
            MentorDAO mentorDAO = new MentorDAO();
            ArrayList<Mentor> suggestionMentor = mentorDAO.getSuggestionMentor(reqSkill);
            AccountDAO accDAO = new AccountDAO();
            ArrayList<String> accName = new ArrayList<>();
            Map<String, Mentor> mapMentor = new HashMap<>();
            Map<String, Integer> mapInviteReq = new HashMap<>();
            Map<String, Integer> mapAcceptedReq = new HashMap<>();
            InviteDAO invDAO = new InviteDAO();
            for (Mentor mentor : suggestionMentor) {               
                if(invDAO.checkDupInvite(mentor.getId(), reqID)){
                String accountName = accDAO.getAccountName(mentor.getId());
                accName.add(accountName);
                mapMentor.put(accountName, mentor);
                mapInviteReq.put(accountName, invDAO.getCountReq(mentor.getId(),"Pending"));
                mapAcceptedReq.put(accountName, invDAO.getCountReq(mentor.getId(),"Accepted"));
                }
            }
            String a = String.valueOf(reqID);
            
            HttpSession session = request.getSession();
            request.setAttribute("REQ_ID", a);
            session.setAttribute("LIST_ACCOUNTNAME", accName);
            session.setAttribute("Map_Mentor", mapMentor);
            session.setAttribute("Map_Invite", mapInviteReq);
            session.setAttribute("Map_Accepted", mapAcceptedReq);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at SuggestionMentorController " + e.toString());
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
