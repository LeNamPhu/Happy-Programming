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
    private static final String INSERTCV = "UPDATE Mentor SET Job=?,Introducton=?,Profession=?,ProfessionIntro=?,"
            + "Framework=?,Service=?,ServiceDesc=?,AchievementDesc=?,Avatar=? WHERE ID=?"; // thêm cái này
     
    public ArrayList<Mentor> viewAllMentor(){
                ArrayList<Mentor> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select ID, Email,FullName,Address,Phone,DateOfBirth,Sex,Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job\n"
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
                        String ProfessionIntro = rs.getString("professionIntro");
                        String ServiceDesc = rs.getString("ServiceDesc");
                        String AchievementDesc = rs.getString("AchievementDesc");
                        String Framework = rs.getString("Framework");
                        String Avatar = rs.getString("Avatar");
                        String Job = rs.getString("Job");
                        String Service = rs.getString("Service");
                        String Introducton = rs.getString("Introducton");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, 
                                                ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Service, Introducton);
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
    
    public boolean insertcv(Mentor mentor) throws SQLException{  // cái này
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtils.makeConnection();
            if(con!=null){
                stm = con.prepareStatement(INSERTCV);
                stm.setString(1, mentor.getJob());
                stm.setString(2, mentor.getIntroducton());
                stm.setString(3, mentor.getProfession());
                stm.setString(4, mentor.getProfessionIntro());
                stm.setString(5, mentor.getFramework());
                stm.setString(6, mentor.getService());
                stm.setString(7, mentor.getServiceDesc());
                stm.setString(8, mentor.getAchievementDesc());
                stm.setString(9, mentor.getAvatar());
                stm.setInt(10, mentor.getId());
                
                check = stm.executeUpdate()>0?true:false;
            }
        }
        catch(Exception e){
            
        }
        finally{
            if(stm!=null) stm.close();
            if(con!=null) con.close();
        }
        
        return check;
    }
    
//    public static Mentor getAvatar(String id) {
//        Connection cn = null;
//        Mentor mentor = null;
//        try {
//            cn = DBUtils.makeConnection();
//            String sql = "SELECT Avatar FROM Mentor where ID=?";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setString(1, id);
//            ResultSet rs = pst.executeQuery();
//            if(rs!=null && rs.next()) {
//                int ID = rs.getInt("ID");
//                String avatar = rs.getString("image");
//                mentor = new Mentor(ID, null, null, null, null, null, null, null, null, null, null, null, avatar, null, null, null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mentor;
//    }
}
