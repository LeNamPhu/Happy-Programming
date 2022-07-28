/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account;
import DTO.Mentee;
import DTO.Mentor;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AccountDAO {

    private static final Logger LOGGER = Logger.getLogger(AccountDAO.class.getName());

    private static final String INSERTACCOUNT = "INSERT INTO Account(AccountName,Password,RoleID) VALUES (?,?,?)";
    private static final String INSERTRMENTOR = "INSERT INTO Mentor(ID, Email, FullName, Phone, Address, DateOfBirth, Sex) VALUES (?,?,?,?,?,?,?)";
    private static final String INSERTRMENTEE = "INSERT INTO Mentee(ID, Email, FullName, Phone, Address, DateOfBirth, Sex) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_PASSWORD = "UPDATE Account SET password=? WHERE AccountName=?";
    private static final String CHECK_DUPLICATE = "SELECT AccountName FROM Account WHERE AccountName=?";
    private static final String CHECK_DUPLICATE_EMAIL = "SELECT Email FROM Mentee WHERE Email=?";
    private static final String CHECK_DUPLICATE_EMAIL1 = "SELECT Email FROM Mentor WHERE Email=?";
    private static final String GET_ACCOUNT_ID = "SELECT ID FROM Account WHERE AccountName=?";

    public ArrayList<Account> viewAllAccount() {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select ID, AccountName,Password,RoleID\n"
                        + "from Account\n";

                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        String AccountName = rs.getString("AccountName");
                        String Password = rs.getString("Password");
                        int RoleID = rs.getInt("RoleID");
                        Account acc = new Account(ID, AccountName, Password, RoleID);
                        list.add(acc);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return list;

    }

    public Account viewAccount(int accId) throws SQLException {
        Account account = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "select ID, AccountName,Password,RoleID\n"
                        + "from Account\n"
                        + "where ID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, accId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int ID = rs.getInt("ID");
                    String AccountName = rs.getString("AccountName");
                    String Password = rs.getString("Password");
                    int RoleID = rs.getInt("RoleID");
                    account = new Account(ID, AccountName, Password, RoleID);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return account;
    }

    public Account checkSignIn(String accountName, String password) throws SQLException {
        Account account = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT ID, RoleID FROM Account WHERE AccountName=? and Password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, accountName);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    int role = rs.getInt("RoleID");
                    account = new Account(id, accountName, password, role);

                }

            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return account;
    }

    public boolean insertAcc(Account account) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERTACCOUNT);
                stm.setString(1, account.getAccountName());
                stm.setString(2, account.getPassword());
                stm.setInt(3, account.getRoleId());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return check;
    }

    public boolean checkDuplicate(String AccountName) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(CHECK_DUPLICATE);
                stm.setString(1, AccountName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public int getAccountId(String AccountName) throws SQLException {
        int accountId = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(GET_ACCOUNT_ID);
                stm.setString(1, AccountName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    accountId = rs.getInt("ID");
                    LOGGER.log(Level.INFO, "ACCOUNT ID : {0}", accountId);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return accountId;
    }

    public boolean updateAccountName(String Name, int id) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Account\n"
                        + "set AccountName = ?\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareCall(sql);
                pst.setString(1, Name);
                pst.setInt(2, id);
                pst.executeUpdate();
                cn.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean updateAccountInfo(String Email, String FullName, Date DOB, String Sex, String Address, int id) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Mentee\n"
                        + "set Email = ?, FullName = ?, Address = ? , DateOfBirth = ?, Sex = ?\n"
                        + "where ID = ? ";
                PreparedStatement pst = cn.prepareCall(sql);
                pst.setString(1, Email);
                pst.setString(2, FullName);
                pst.setString(3, Address);
                pst.setDate(4, DOB);
                pst.setString(5, Sex);
                pst.setInt(6, id);
                pst.executeUpdate();
                cn.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean insertMentee(Mentee mentee) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERTRMENTEE);
                stm.setInt(1, mentee.getId());
                stm.setString(2, mentee.getEmail());
                stm.setString(3, mentee.getFullname());
                stm.setString(4, mentee.getPhone());
                stm.setString(5, mentee.getAddress());
                stm.setDate(6, mentee.getDob());
                stm.setString(7, mentee.getSex());
                check = stm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean insertMentor(Mentor mentor) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERTRMENTOR);
                stm.setInt(1, mentor.getId());
                stm.setString(2, mentor.getEmail());
                stm.setString(3, mentor.getFullname());
                stm.setString(4, mentor.getPhone());
                stm.setString(5, mentor.getAddress());
                stm.setDate(6, mentor.getDob());
                stm.setString(7, mentor.getSex());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    

    public boolean changePassword(String Password, String AccountName) throws SQLException {
        
        // "UPDATE dbo.Account SET password='?' WHERE AccountName='?'";
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(UPDATE_PASSWORD);
                stm.setString(1, Password);
                stm.setString(2, AccountName);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return check;
    }
    public String getAccountName(int id) throws SQLException{
        String accountName = "";
                Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {               
                    String sql = "SELECT AccountName FROM Account WHERE ID=? ";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, id);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        accountName = rs.getString("AccountName");
                    }              
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return accountName;

    }
    public boolean checkEmail(String Email) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(CHECK_DUPLICATE_EMAIL);
                stm.setString(1, Email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    public boolean checkEmail1(String Email) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(CHECK_DUPLICATE_EMAIL);
                stm.setString(1, Email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
}
