/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Mentor;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class MentorDAO {
    public ArrayList<Mentor> viewAllMentor(){
                ArrayList<Mentor> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select ID, Email,FullName,Address,Phone,DateOfBirth,Sex,Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar\n"
                        + "from Mentor\n";

                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        String Email = rs.getString("Email");
                        String FullName = rs.getString("FullName");
                        String Address = rs.getString("Address");
                        String Phone = rs.getString("Phone");
                        Date DateOfBirth = rs.getDate("DateOfBirth");
                        String Sex = rs.getString("Phone");
                        String Profession = rs.getString("Phone");
                        String ProfessionIntro = rs.getString("Phone");
                        String ServiceDesc = rs.getString("Phone");
                        String AchievementDesc = rs.getString("Phone");
                        String Framework = rs.getString("Phone");
                        String Avatar = rs.getString("Phone");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar);
                        list.add(mtr);
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
