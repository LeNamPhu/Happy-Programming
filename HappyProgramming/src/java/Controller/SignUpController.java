/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DTO.Account;
import DTO.Mentee;
import DTO.Mentor;
import DTO.UserError;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author trida
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {
    private final String ERROR = "SignUp.jsp";
    private final String SUCCESS = "SendOTP.jsp";
    
    private static final Logger LOGGER = Logger.getLogger( SignUpController.class.getName() );
    
//    private static enum SexEnum {
//        MALE("M"),
//        FEMALE("F"),
//        OTHER("O");
//        public final String _value;
//        
//        SexEnum(String value) { _value = value; }
//    }
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        try {
            String accountName = request.getParameter("accountName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            Date dob = Date.valueOf(request.getParameter("dob"));
            //String sex = SexEnum.valueOf(request.getParameter("sex").toUpperCase())._value;
            String sex = request.getParameter("sex");
//            LOGGER.log(Level.INFO, "Current Sex is {0}", sex);
            
            int roleID = Integer.parseInt(request.getParameter("roleId"));
            String address = request.getParameter("address");
           
            boolean checkValid = true;
            AccountDAO dao = new AccountDAO();
            boolean check = dao.checkDuplicate(accountName);
            if(check){
                checkValid = false;
                userError.setAccError("Duplicate AccountName!!");
            }
            
            if(accountName.length()<6 || accountName.length()>20){
                checkValid = false;
                userError.setAccError("User ID must be in [6,20]");
            }
            
            
            if(!password.equals(confirm)){
                checkValid = false;
                userError.setPassError("Confirm is not same!!");
            }
            
            if(checkValid){
                Account acc = new Account(0,accountName, password, roleID);
                boolean checkinsert = dao.insertAcc(acc);
                int accountid = dao.getAccountId(acc.getAccountName());
                if(checkinsert){
                    if(roleID == 1){
                        Mentee tee = new Mentee(accountid, email, fullName, address, phone, dob, sex,null);
                        boolean insertMentee = dao.insertMentee(tee);
                        if(insertMentee){
                            url = SUCCESS;
                        }
                    }
                    else if(roleID == 2){
                        Mentor tor = new Mentor(accountid, email, fullName, address, phone, dob, sex,null,null,null,null,null,"image/user ava.jpg",null,null,null);
                        boolean insertMentor = dao.insertMentor(tor);
                        if(insertMentor){
                            url = SUCCESS;
                        }
                    }
                }
            }
            else{
                request.setAttribute("USER_ERROR", userError);
            }
            
        }
        catch(Exception e){
            log("Error at SignUpController" + e.toString());
//            if(e.toString().contains("duplicate")){
//                userError.setAccError("Duplicate User ID!!!");
//                request.setAttribute("USER_ERROR", userError);
//            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
