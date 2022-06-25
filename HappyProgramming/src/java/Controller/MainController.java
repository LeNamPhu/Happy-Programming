/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThienNho
 */
public class MainController extends HttpServlet {

    public static final String ERROR = "Error.jsp";
    public static final String LIST_REQUEST_BY_MENTEE = "ListRequestByMenteeController";
    public static final String DELETE_REQUEST_BY_MENTEE = "DeleteRequestByMenteeController";
    public static final String UPDATE_REQUEST_BY_MENTEE = "UpdateRequestByMenteeController";
    public static final String SIGN_IN = "SignInController";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
             String action = request.getParameter("action");
             if("ListRequestByMentee".equals(action)){
                url = LIST_REQUEST_BY_MENTEE;
            }else if("DeleteRequest".equals(action)){
                url = DELETE_REQUEST_BY_MENTEE;
            }else if("UpdateRequest".equals(action)){
                url = UPDATE_REQUEST_BY_MENTEE;
            }else if("Sign in".equals(action)){
                url = SIGN_IN;
            }else if("addSkill".equals(action)){
                url = "addSkill";
            }else if("updateSkill".equals(action)){
                url = "updateSkill";
            }
            
            else{
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "Funtion is not available!!!");
            }        
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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