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
}
