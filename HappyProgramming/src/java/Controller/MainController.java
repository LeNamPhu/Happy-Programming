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
    public static final String CREATE_REQUEST_BY_MENTEE = "CreateRequestByMenteeController";
    public static final String ACCEPT_REQUEST = "AcceptRequestController";
    public static final String REJECT_REQUEST = "RejectRequestController";
    public static final String LIST_INVITE_REQUEST = "ListInviteController";
    public static final String SIGN_IN = "SignInController";
    public static final String STATISTIC_BY_MENTEE = "StatisticByMenteeController";
    public static final String SIGN_UP = "Create";
    public static final String SIGNUP_Controller = "SignUpController";


    public static final String CHANGE_PASWORD_BY_MENTEE_CONTROLLER = "ChangePasswordMenteeController";
    public static final String CHANGE_PASWORD_BY_MENTOR_CONTROLLER = "ChangePasswordMentorController";
    public static final String CREATE_CV = "CreateCVController";
    public static final String RATE = "RateController";
    public static final String SUGGESTION_MENTOR = "SuggestionMentorController";
    public static final String INVITE = "InviteController";
    public static final String STATISTIC_BY_MENTOR = "StatisticByMentorController";

    public static final String ADD = "Add";
    public static final String CREATE_REQUEST = "CreateRequestController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("ListRequestByMentee".equals(action)) {
                url = LIST_REQUEST_BY_MENTEE;
            } else if ("DeleteRequest".equals(action)) {
                url = DELETE_REQUEST_BY_MENTEE;
            } else if ("UpdateRequest".equals(action)) {
                url = UPDATE_REQUEST_BY_MENTEE;
            } else if ("CreateRequest".equals(action)) {
                url = CREATE_REQUEST_BY_MENTEE;
            } else if ("Sign in".equals(action)) {
                url = SIGN_IN;
            } else if ("addSkill".equals(action)) {
                url = "addSkill";
            } else if ("changeStatus".equals(action)) {
                url = "changeStatusSkill";
            } else if ("updateSkill".equals(action)) {
                url = "updateSkill";
            } else if ("Reject Request".equals(action)) {
                url = REJECT_REQUEST;
            } else if ("Invite Request".equals(action)) {
                url = LIST_INVITE_REQUEST;
            } else if ("Accept Request".equals(action)) {
                url = ACCEPT_REQUEST;
            } else if ("Statistic by Mentee".equals(action)) {
                url = STATISTIC_BY_MENTEE;
            } else if ("LogOut".equals(action)) {
                url = "LogOutController";

            } else if ("changeMentorStatus".equals(action)) {    
                url = "changeMentorStatus";
            } else if ("searchMentor".equals(action)) {
                url = "searchMentor";      

            

            } else if ("ListRequestByMentor".equals(action)) {
                url = "MentorRequestController";
            } else if ("FollowingRequest".equals(action)) {
                url = "FollowingRequestController";
            } else if ("StatisticRequest".equals(action)) {
                url = STATISTIC_BY_MENTOR;

            } else if ("InvitingRequest".equals(action)) {
                url = "InvitingRequestController";
            } else if (ADD.equals(action)) {
                url = CREATE_REQUEST;
            } else if (SIGN_UP.equals(action)) {
                url = SIGNUP_Controller;
            } else if ("searchRequest".equals(action)) {
                url = "searchRequest";
            } else if ("filterRequest".equals(action)) {
                url = "filterRequest";

            } else if ("Enter".equals(action)) {
                url = CHANGE_PASWORD_BY_MENTEE_CONTROLLER;
            } else if (" Enter ".equals(action)) {
                url = CHANGE_PASWORD_BY_MENTOR_CONTROLLER;
            } else if ("Cancel".equals(action)) {
                url = "UserHomePage.jsp";
            } else if (" Cancel ".equals(action)) {
                url = "MentorHomePage.jsp";
            }else if("CreateCV".equals(action)){
                url = CREATE_CV;
            }else if("Rate".equals(action)){
                url = RATE;
            }else if("ShowMentorSuggestion".equals(action)){
                url = SUGGESTION_MENTOR;
            }else if("Invite".equals(action)){
                url = INVITE;
                 
            
            } else if ("Update".equals(action)) {
                url = "UpdateProfileController";
        }
            else{
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "Funtion is not available!!!");
            }        


        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
