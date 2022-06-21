/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MenteeDAO;
import DAO.SkillDAO;
import DTO.Account;
import DTO.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThienNho
 */
@WebServlet(name = "ListRequestByMenteeController", urlPatterns = {"/ListRequestByMenteeController"})
public class ListRequestByMenteeController extends HttpServlet {

  private final String ERROR = "Error.jsp";
  private final String SUCCESS = "ListRequestByMentee.jsp";
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{       
        Account user = (Account) request.getAttribute("SIGNIN_ACCOUNT");
        int id = user.getId();
        MenteeDAO dao = new MenteeDAO();
        SkillDAO abc = new SkillDAO();
        ArrayList<Request> list = dao.listRequestByMentee(id);
        request.setAttribute("LIST_SKILL", abc.getListSkillName());
        
            request.setAttribute("LIST_REQUEST_BY_MENTEE", list);            
            Map<Request, String> map = new HashMap<>();
            for (Request a : list){
                ArrayList<Integer> listIDSkillReq = dao.getIDSkillReq(a);
                dao.getNameSkillReq(listIDSkillReq, a, map);
            }
            request.setAttribute("SKILL_REQUEST", map);
            url = SUCCESS;
        
        }catch(Exception e){
            log("Error at ListRequestByMenteeController" + e.toString());
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
