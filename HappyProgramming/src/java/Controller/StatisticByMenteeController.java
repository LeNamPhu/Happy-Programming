/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InviteDAO;
import DAO.MentorDAO;
import DAO.RequestDAO;
import DTO.Account;
import DTO.Request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "StatisticByMenteeController", urlPatterns = {"/StatisticByMenteeController"})
public class StatisticByMenteeController extends HttpServlet {

    private final String ERROR = "Error.jsp";
    private final String SUCCESS = "StatisticByMentee.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int menteeID = 2;
            RequestDAO reqDAO = new RequestDAO();
            ArrayList<Request> listReq = reqDAO.getListClosedReq(menteeID);
            ArrayList<Integer> listReqID = new ArrayList<>();
            int totalHour = 0;
            int totalRequest = 0;
            ArrayList<String> listTitle = new ArrayList<>();
            for (Request req : listReq) {
                totalRequest = totalRequest + 1;
                totalHour = totalHour + req.getDeadlineHour();
                listTitle.add(req.getTitle());
                listReqID.add(req.getId());
            }
            InviteDAO inviteDAO = new InviteDAO();
            ArrayList<Integer> listMentorID = inviteDAO.getListMentorIDByReqID(listReqID);
            MentorDAO mentorDAO = new MentorDAO();
            ArrayList<String> listMentor = mentorDAO.getListNameMentor(listMentorID);  
            String abc = String.valueOf(totalHour);
            String xyz = String.valueOf(totalRequest);
            request.setAttribute("TOTAL_REQUEST", xyz);
            request.setAttribute("TOTAL_HOUR", abc);
            request.setAttribute("LIST_TITLE", listTitle);
            request.setAttribute("LIST_MENTOR", listMentor);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at DeleteRequestByMenteeController " + e.toString());
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
