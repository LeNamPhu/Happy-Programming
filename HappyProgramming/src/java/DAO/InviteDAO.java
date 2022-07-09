/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ThienNho
 */
public class InviteDAO {

    public void updateStatusInvite(int reqID, int mentorID, String status) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "UPDATE Invite SET Status=? WHERE ReqID=? and MentorID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, status);
                stm.setInt(2, reqID);
                stm.setInt(3, mentorID);
                int value = stm.executeUpdate();
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
    }

    public void deleteInvite(int reqID, int mentorID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "DELETE Invite WHERE ReqID=? and MentorID=? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, reqID);
                stm.setInt(2, mentorID);
                int value = stm.executeUpdate();
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
    }

    public ArrayList<Integer> getListMentorIDByReqID(ArrayList<Integer> listReq) throws SQLException {
        ArrayList<Integer> listMentorID = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer reqID : listReq) {
                    String sql = "SELECT MentorID FROM Invite WHERE ReqID=? ";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, reqID);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        listMentorID.add(rs.getInt("MentorID"));
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
        return listMentorID;
    }
    
    public int getCountReq(int mentorID, String status) throws SQLException{
        int count = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                
                    String sql = "SELECT * FROM Invite WHERE Status=? and MentorID=?";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, status);
                    stm.setInt(2, mentorID);
                    rs = stm.executeQuery();
                    while (rs.next()) {
                        count ++;
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
        return count;
    }
    public void insertInvite(int mentorID, int reqID) throws SQLException{
         Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {                
                    String sql = "INSERT INTO Invite(ReqID, MentorID, Status) VALUES (?,?,?) ";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, reqID);
                    stm.setInt(2, mentorID);
                    stm.setString(3,"Pending");
                    stm.executeUpdate();                                
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
    }
    
    public boolean checkDupInvite(int mentorID, int reqID) throws SQLException{
        boolean check = true;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {                
                    String sql = "SELECT * FROM INVITE WHERE ReqID=? AND MentorID=? AND Status=? ";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, reqID);
                    stm.setInt(2, mentorID);
                    stm.setString(3,"Pending");
                    rs = stm.executeQuery();
                    if(rs.next()){
                        check = false;
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

        return check;
    }
}
