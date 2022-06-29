/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Request;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ThienNho
 */
public class RequestDAO {

    public static final String LIST_REQUEST_BY_MENTEE = "SELECT ID, Title, Status, Content, DeadlineDate, DeadlineHour FROM Request WHERE MenteeID=?";
    public static final String GET_SKILL_ID = "SELECT skillID FROM RequestSkill WHERE RequestID=?";
    public static final String GET_SKILL_NAME = "SELECT Name FROM Skill WHERE ID=?";
    public static final String DELETE_REQUEST = "UPDATE Request SET Status=? WHERE ID=?";
    public static final String UPDATE_REQUEST = "UPDATE Request SET Title=?, Content=?, DeadlineDate=?, DeadlineHour=? WHERE ID=?";
    public static final String DELETE_SKILL_REQUEST = "DELETE RequestSkill WHERE RequestID =? ";

    public ArrayList<Request> listRequestByMentee(int menteeID) throws SQLException {
        ArrayList<Request> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = LIST_REQUEST_BY_MENTEE;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, menteeID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if ("Open".equals(rs.getString("Status"))  || "Processing".equals(rs.getString("Status")) /*|| "Open".equals(rs.getString("Status"))*/) {
                        int ID = rs.getInt("ID");
                        String title = rs.getString("Title");
                        String status = rs.getString("Status");
                        String content = rs.getString("Content");
                        Date deadlineDate = rs.getDate("DeadlineDate");
                        int deadlineHour = rs.getInt("DeadlineHour");
                        list.add(new Request(ID, title, status, content, menteeID, deadlineDate, deadlineHour));
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
        return list;
    }

    public ArrayList<Integer> getIDSkillReq(Request req) throws SQLException {
        ArrayList<Integer> listID = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = GET_SKILL_ID;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, req.getId());
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("skillID");
                    listID.add(id);
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
        return listID;
    }

    public void getNameSkillReq(ArrayList<Integer> listID, Request req, Map<Request, String> map) throws SQLException {
        String listNameSkill = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer id : listID) {
                    String sql = GET_SKILL_NAME;
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, id);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        String skillName = rs.getString("Name");
                        listNameSkill += skillName + " ";
                    }
                }
                map.put(req, listNameSkill);
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

    public void deleteReq(int reqID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = DELETE_REQUEST;
                stm = conn.prepareStatement(sql);
                stm.setString(1, "Cancel");
                stm.setInt(2, reqID);
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

    public void updateReq(Request req) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = UPDATE_REQUEST;
                stm = conn.prepareStatement(sql);
                stm.setString(1, req.getTitle());
                stm.setString(2, req.getContent());
                stm.setDate(3, req.getDeadlineDate());
                stm.setInt(4, req.getDeadlineHour());
                stm.setInt(5, req.getId());
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

    public void updateSkillReq(int reqID, String skill1, String skill2, String skill3) throws SQLException {
        deleteSkillReq(reqID);
        ArrayList<Integer> listSkillID = getSkillIDByName(skill1, skill2, skill3);
        insertSkillIDToRequestSkill(reqID, listSkillID);
    }

    public void deleteSkillReq(int reqID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "DELETE RequestSkill WHERE RequestID =? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, reqID);
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

    public ArrayList<Integer> getSkillIDByName(String skill1, String skill2, String skill3) throws SQLException {
        ArrayList<String> listName = new ArrayList<>();
        listName.add(skill1);
        listName.add(skill2);
        listName.add(skill3);
        ArrayList<Integer> listSkillID = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (String Name : listName) {
                    String sql = "SELECT ID FROM Skill WHERE Name=? and Status='active'";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, Name);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        listSkillID.add(rs.getInt("ID"));
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

        return listSkillID;
    }

    public void insertSkillIDToRequestSkill(int reqID, ArrayList<Integer> listSkillID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer ID : listSkillID) {
                    String sql = "INSERT INTO RequestSkill (SkillID,RequestID) VALUES (?,?)";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, ID);
                    stm.setInt(2, reqID);
                    int value = stm.executeUpdate();
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
    }


    public ArrayList<Integer> getListInviteRequestID(int id) throws SQLException{
        ArrayList<Integer> listInviteRequestID = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT ReqID FROM Invite WHERE MentorID =? and Status =?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, id);
                stm.setString(2, "Processing");
                rs = stm.executeQuery();
                while(rs.next()){
                    int reqID = rs.getInt("ReqID");
                    listInviteRequestID.add(reqID);
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
        
        return listInviteRequestID;
    }
    
    public ArrayList<Request> getListInviteRequest(ArrayList<Integer> listInviteRequestID) throws SQLException{
        ArrayList<Request> listInviteRequest = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer reqID : listInviteRequestID) {
                    String sql = "SELECT Title, Content, MenteeID, DeadlineDate, DeadlineHour FROM Request WHERE ID=? and Status=?";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, reqID);
                    stm.setString(2, "Processing");
                    rs = stm.executeQuery();
                    if (rs.next()) {                        
                        listInviteRequest.add(new Request(reqID, rs.getString("Title"), "Processing", rs.getString("Content"), rs.getInt("MenteeID") , rs.getDate("DeadlineDate"), rs.getInt("DeadlineHour")));
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
        
        return listInviteRequest;
    }
    
    public void updateStatusRequest(int reqID, String status) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "UPDATE Request SET Status=? WHERE ID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, status);  
                stm.setInt(2, reqID);                                         
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
    
    public ArrayList<Request> getListClosedReq(int menteeID) throws SQLException{
         ArrayList<Request> list = new ArrayList<>();
         Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = LIST_REQUEST_BY_MENTEE;
                stm = conn.prepareStatement(sql);
                 stm.setInt(1, menteeID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if ("Closed".equals(rs.getString("Status"))) {
                        int ID = rs.getInt("ID");
                        String title = rs.getString("Title");
                        String status = rs.getString("Status");
                        String content = rs.getString("Content");
                        Date deadlineDate = rs.getDate("DeadlineDate");
                        int deadlineHour = rs.getInt("DeadlineHour");
                        list.add(new Request(ID, title, status, content, menteeID, deadlineDate, deadlineHour));
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
        return list;
    }


    public static int countRequestOfMentor(int mentorId, String status) {
        Connection cn = null;
        int num = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select count(Invite.Status) as numberOfRequest \n"
                        + "from Request join Invite on Request.ID = ReqID\n"
                        + "where MentorID = ? and Invite.Status = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, mentorId);
                pst.setString(2, status);
                ResultSet rs = pst.executeQuery();
                if(rs!=null && rs.next())
                    num = rs.getInt("numberOfRequest");
            }
        } catch (Exception e) {
        }
        return num;
    }

}
