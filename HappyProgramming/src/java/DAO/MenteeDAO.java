/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Mentee;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ThienNho
 */
public class MenteeDAO {

    public static ArrayList<Mentee> getAllMentees() {
        Connection cn = null;
        ArrayList<Mentee> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from Mentee";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String email = rs.getString("Email");
                    String fullName = rs.getString("FullName");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    Date DOB = rs.getDate("DateOfBirth");
                    String sex = rs.getString("Sex");
                    String avatar = rs.getString("Avatar");
                    Mentee mt = new Mentee(ID, email, fullName, address, phone, DOB, sex, avatar);
                    list.add(mt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getMenteeAccountNameById(int id) {
        Connection cn = null;
        String accountName = "";
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select AccountName\n"
                        + "from Mentee join Account on Mentee.ID = Account.ID\n"
                        + "where Mentee.ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    accountName = rs.getString("AccountName");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountName;
    }
    
}
