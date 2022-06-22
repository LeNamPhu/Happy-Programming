/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AccountDAO {
    public ArrayList<Account> viewAllMentor(){
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
    
    public Account checkSignIn(String accountName, String password) throws SQLException{
        Account account = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql ="SELECT ID, RoleID FROM Account WHERE AccountName=? and Password=?" ;
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
    
    public static Account getAccount(String name, String pass){
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select ID,AccountName,Password,RoleID\n"
                        + "from dbo.Account\n"
                        + "where AccountName = ? and Password = ? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, pass);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int id = rs.getInt("ID");
                    String accName = rs.getString("AccountName");
                    String password = rs.getString("Password");
                    int roleID = rs.getInt("RoleID");
                    acc = new Account(id, accName, password, roleID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return acc;
        }
        
    }
}
