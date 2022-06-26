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
import java.sql.SQLException;
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
                        String Sex = rs.getString("Sex");
                        String Profession = rs.getString("Profession");
                        String ProfessionIntro = rs.getString("ProfessionIntro");
                        String ServiceDesc = rs.getString("ServiceDesc");
                        String AchievementDesc = rs.getString("AchievementDesc");
                        String Framework = rs.getString("Framework");
                        String Avatar = rs.getString("Avatar");
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
    
    public ArrayList<String> getListNameMentor(ArrayList<Integer> listMentorID)  throws SQLException{
        ArrayList<String> listName = new ArrayList<>();
         Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer mentorID : listMentorID) {
                String sql = "SELECT FullName FROM Mentor WHERE ID=? ";
                stm = conn.prepareStatement(sql);               
                stm.setInt(1, mentorID);                                                                                               
                rs = stm.executeQuery();
                if(rs.next()){
                    listName.add(rs.getString("FullName"));
                }
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
        return listName;
    }
}
