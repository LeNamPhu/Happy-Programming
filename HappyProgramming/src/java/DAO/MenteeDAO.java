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
 * @author
 */
public class MenteeDAO {

    public static ArrayList<Mentee> getAllMentees() {
        Connection cn = null;
        ArrayList<Mentee> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from Mentee ";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String email = rs.getString("Email");
                    String fullName = rs.getString("FullName");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    Date Dob = rs.getDate("DateOfBirth");
                    String sex = rs.getString("Sex");
                    String avatar = rs.getString("Avatar");
                    Mentee mt = new Mentee(ID, email, fullName, address, phone, Dob, sex, avatar);
                    list.add(mt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getAccountNameByMenteeID(int menteeID) {
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select AccountName\n"
                        + "from Mentee join Account on Mentee.ID = Account.ID\n"
                        + "where Mentee.ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menteeID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    result = rs.getString("AccountName");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Mentee getAccountByMenteeID(int menteeID) {
        Mentee mt = null;
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from Mentee\n"
                        + "where Mentee.ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menteeID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String email = rs.getString("Email");
                    String fullName = rs.getString("FullName");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    Date Dob = rs.getDate("DateOfBirth");
                    String sex = rs.getString("Sex");
                    String avatar = rs.getString("Avatar");
                    mt = new Mentee(ID, email, fullName, address, phone, Dob, sex, avatar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mt;
    }
    
        public static boolean updateAccountStatus(String Email, String FullName, Date DOB, String Sex,String Address) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update dbo.Mentee\n"
                        + "set Email = ?, FullName = ?, Address = ? , DareOfBirth = ?, Sex = ?\n"
                        + "where email = ? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareCall(sql);
                pst.setString(1, Email);
                pst.setString(2, FullName);
                pst.setString(3, Address);
                pst.setDate(4, DOB);
                pst.setString(5, Sex);
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
}
