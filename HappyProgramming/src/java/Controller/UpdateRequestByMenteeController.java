/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RequestDAO;
import DTO.Account;
import DTO.Request;
import DTO.RequestError;
import java.io.IOException;
import java.sql.Date;
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

    private final String ERROR = "UpdateRequest.jsp";
    private final String SUCCESS = "ListRequestByMenteeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession(true);
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            int menteeID = user.getId();
            boolean checkError = true;
            RequestError reqE = new RequestError();
            int reqID = Integer.parseInt(request.getParameter("reqIDForUpdate"));
            String a = String.valueOf(reqID);
            request.setAttribute("REQ_ID", a);
            String title = request.getParameter("title");
            if (title.isEmpty()) {
                reqE.setTitleError("Please input the title!!");
                checkError = false;
            }
            String status = request.getParameter("status");
            Date deadlineDate = Date.valueOf(request.getParameter("deadlineDate"));
            if (deadlineDate.before(new java.util.Date())) {
                reqE.setDateError("Please choose deadline date after today!!");
                checkError = false;
            }
            int deadlineHour = 0;
            try {
                deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
                if (deadlineHour < 0) {
                    throw new NumberFormatException();
                }
                if (deadlineHour >= 24){
                     checkError = false;
                reqE.setHourError("Please input an hour from 0 to 23!!");
                }
            } catch (NumberFormatException e) {
                checkError = false;
                reqE.setHourError("Please input a positive integer!!");
            }
            
            String content = request.getParameter("content");
            if (content.isEmpty()) {
                reqE.setContentError("Please input the content!!");
                checkError = false;
            }
            Request req = new Request(reqID, title, status, content, menteeID, deadlineDate, deadlineHour);
            String skill1 = request.getParameter("skill1");
            String skill2 = request.getParameter("skill2");
            String skill3 = request.getParameter("skill3");
            if (skill1.isEmpty() && skill2.isEmpty() && skill3.isEmpty()) {
                checkError = false;
                reqE.setSkillError("Please choose at least one skill!!");
            }
            request.setAttribute("REQUEST_ERROR", reqE);
            if (checkError) {
                RequestDAO dao = new RequestDAO();
                dao.updateReq(req);
                dao.updateSkillReq(reqID, skill1, skill2, skill3);
                url = SUCCESS;
            }

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