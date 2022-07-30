package Controller;

import DAO.RequestDAO;
import DTO.Account;
import DTO.Request;
import DTO.RequestError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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

    private final String ERROR = "CreateRequest.jsp";
    private final String SUCCESS = "ListRequestByMenteeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession(true);
            Account user = (Account) session.getAttribute("SIGNIN_ACCOUNT");
            boolean checkError = true;
            RequestError reqE = new RequestError();
            int menteeID = user.getId();
            String status = "Open";
            String title = request.getParameter("title");
            if (title.isEmpty()) {
                reqE.setTitleError("Please input the title!!");
                checkError = false;
            }
            String content = request.getParameter("content");
            if (content.isEmpty()) {
                reqE.setContentError("Please input the content!!");
                checkError = false;
            }
            Date deadlineDate = new Date(0);
            try {
                deadlineDate = Date.valueOf(request.getParameter("deadlineDate"));
            if (deadlineDate.before(new java.util.Date()) || deadlineDate.equals(new java.util.Date())) {
                throw new IllegalArgumentException();
            }
            } catch (IllegalArgumentException e) {
                reqE.setDateError("Please choose deadline date after today!!");
                checkError = false;
            }
            
            int deadlineHour = 0;
            try {
                deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
                if (deadlineHour <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                checkError = false;
                reqE.setHourError("Please input a positive integer!!");
            }

            Request req = new Request(0, title, status, content, menteeID, deadlineDate, deadlineHour);
            RequestDAO reqdao = new RequestDAO();

            ArrayList<Integer> listSkillID = new ArrayList<>();
            int skill1 = Integer.parseInt(request.getParameter("skill1"));
            if (skill1 != 0) {
                listSkillID.add(skill1);
            }
            int skill2 = Integer.parseInt(request.getParameter("skill2"));
            if (skill2 != 0) {
                listSkillID.add(skill2);
            }
            int skill3 = Integer.parseInt(request.getParameter("skill3"));
            if (skill3 != 0) {
                listSkillID.add(skill3);
            }
            if (skill1 == 0 && skill2 == 0 && skill3 == 0) {
                checkError = false;
                reqE.setSkillError("Please choose at least one skill!!");
            }
            request.setAttribute("REQUEST_ERROR", reqE);
            if (checkError) {
                boolean checkinsert = reqdao.insertREQ(req);
                if (checkinsert) {
                    int getReqID = reqdao.getMaxReqID();
                    reqdao.insertSkillIDToRequestSkill(getReqID, listSkillID);
                    url = SUCCESS;
                }
            }

        } catch (Exception e) {
            log("Error at CreateRequestController: " + e.toString());
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