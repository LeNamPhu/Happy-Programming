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
    public static final String INSERT_REQUEST = "INSERT INTO Request(Title, Status, Content, MenteeID, DeadlineDate, DeadlineHour) VALUES (?,?,?,?,?,?)";
    public static final String LIST_REQUEST_BY_MENTOR = "SELECT Title, Content, DeadlineDate, DeadlineHour, Name, Request.Status FROM ((Request join Invite on Request.ID = Invite.ReqID) join RequestSkill on Request.ID = RequestSkill.RequestID) join Skill on RequestSkill.SkillID = Skill.ID WHERE MentorID=?";
    public static final String LIST_FOLLOWING_REQUEST = "SELECT Title, Content, DeadlineDate, DeadlineHour, Name FROM ((Request join Invite on Request.ID = Invite.ReqID) join RequestSkill on Request.ID = RequestSkill.RequestID) join Skill on RequestSkill.SkillID = Skill.ID WHERE MentorID = ? And Request.Status = 'Closed'";
    public static final String LIST_INVITING_REQUEST = "SELECT Title, Content, DeadlineDate, DeadlineHour, Name FROM ((Request join Invite on Request.ID = Invite.ReqID) join RequestSkill on Request.ID = RequestSkill.RequestID) join Skill on RequestSkill.SkillID = Skill.ID WHERE MentorID = ? And Invite.Status = 'Pending'";

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
                    if ("Open".equals(rs.getString("Status")) || "Processing".equals(rs.getString("Status")) /*|| "Open".equals(rs.getString("Status"))*/) {
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

    public ArrayList<Request> listRequestByMentor(int MentorID) throws SQLException {
        ArrayList<Request> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = LIST_REQUEST_BY_MENTOR;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, MentorID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String title = rs.getString("Title");
                    String content = rs.getString("Content");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    String status = rs.getString("Status");
                    list.add(new Request(0, title, status, content, 0, deadlineDate, deadlineHour));
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

    public ArrayList<Request> listFollowingByMentor(int MentorID) throws SQLException {
        ArrayList<Request> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = LIST_FOLLOWING_REQUEST;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, MentorID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String title = rs.getString("Title");
                    String content = rs.getString("Content");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    list.add(new Request(0, title, "null", content, 0, deadlineDate, deadlineHour));
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

    public ArrayList<Request> listInvitingRequest(int MentorID) throws SQLException {
        ArrayList<Request> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = LIST_INVITING_REQUEST;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, MentorID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String title = rs.getString("Title");
                    String content = rs.getString("Content");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    list.add(new Request(0, title, "null", content, 0, deadlineDate, deadlineHour));
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

    public ArrayList<Integer> getListInviteRequestID(int id) throws SQLException {
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
                while (rs.next()) {
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

    public ArrayList<Request> getListInviteRequest(ArrayList<Integer> listInviteRequestID) throws SQLException {
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
                        listInviteRequest.add(new Request(reqID, rs.getString("Title"), "Processing", rs.getString("Content"), rs.getInt("MenteeID"), rs.getDate("DeadlineDate"), rs.getInt("DeadlineHour")));
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

    public void updateStatusRequest(int reqID, String status) throws SQLException {
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

    public ArrayList<Request> getListClosedReq(int menteeID) throws SQLException {
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
                if (rs != null && rs.next()) {
                    num = rs.getInt("numberOfRequest");
                }
            }
        } catch (Exception e) {
        }
        return num;
    }

    public boolean insertREQ(Request req) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERT_REQUEST);
                stm.setString(1, req.getTitle());
                stm.setString(2, req.getStatus());
                stm.setString(3, req.getContent());
                stm.setInt(4, req.getMenteeID());
                stm.setDate(5, req.getDeadlineDate());
                stm.setInt(6, req.getDeadlineHour());
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

    public static int getHoursOfRequestByMenteeID(int menteeID) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select SUM(DATEDIFF(DAY,CreatedDate,DeadlineDate)*24+(DATEPART(HOUR,CreatedDate)-DeadlineHour)) as TotalHoursOfRequest\n"
                        + "from Request\n"
                        + "where MenteeID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menteeID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    result = rs.getInt("TotalHoursOfRequest");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Request> viewAllRequest() {
        Connection cn = null;
        ArrayList<Request> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from Request";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String title = rs.getString("Title");
                    String status = rs.getString("Status");
                    String content = rs.getString("Content");
                    int menteeID = rs.getInt("MenteeID");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    Request req = new Request(ID, title, status, content, menteeID, deadlineDate, deadlineHour);
                    list.add(req);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Request> requestPagination(int start, int total) {
        ArrayList<Request> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Request\n"
                        + "order by ID asc \n"
                        + "	OFFSET ? rows\n"
                        + "	fetch next ? rows only;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, start);
                pst.setInt(2, total);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        String title = rs.getString("Title");
                        String status = rs.getString("Status");
                        String content = rs.getString("Content");
                        int menteeID = rs.getInt("MenteeID");
                        Date deadlineDate = rs.getDate("DeadlineDate");
                        int deadlineHour = rs.getInt("DeadlineHour");
                        Request req = new Request(ID, title, status, content, menteeID, deadlineDate, deadlineHour);
                        list.add(req);
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

    public static ArrayList<Request> filterRequest(String keyword, String status, Date from, Date to) {
        Connection cn = null;
        ArrayList<Request> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Request.ID,Title, Status,Content, MenteeID, DeadlineDate, DeadlineHour, CreatedDate \n"
                        + "from Request join Account on MenteeID = Account.ID\n"
                        + "where AccountName like ? and Status like ? and CreatedDate between ? and ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                pst.setString(2, status);
                pst.setDate(3, from);
                pst.setDate(4, to);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String title = rs.getString("Title");
                    String Status = rs.getString("Status");
                    String content = rs.getString("Content");
                    int menteeID = rs.getInt("MenteeID");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    Request req = new Request(ID, title, Status, content, menteeID, deadlineDate, deadlineHour);
                    list.add(req);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Request> filterRequestPagination(String keyword, String status, Date from, Date to, int start, int total) {
        Connection cn = null;
        ArrayList<Request> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Request.ID,Title, Status,Content, MenteeID, DeadlineDate, DeadlineHour, CreatedDate \n"
                        + "from Request join Account on MenteeID = Account.ID\n"
                        + "where AccountName like ? and Status like ? and CreatedDate between ? and ?\n"
                        + "order by ID asc\n"
                        + "OFFSET ? rows\n"
                        + "fetch next ? rows only";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                pst.setString(2, status);
                pst.setDate(3, from);
                pst.setDate(4, to);
                pst.setInt(5, start);
                pst.setInt(6, total);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String title = rs.getString("Title");
                    String Status = rs.getString("Status");
                    String content = rs.getString("Content");
                    int menteeID = rs.getInt("MenteeID");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    Request req = new Request(ID, title, Status, content, menteeID, deadlineDate, deadlineHour);
                    list.add(req);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Request> searchRequestByAccountName(String keyword) {
        Connection cn = null;
        ArrayList<Request> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Request.ID,Title, Status,Content, MenteeID, DeadlineDate, DeadlineHour, CreatedDate \n"
                        + "from Request join Account on MenteeID = Account.ID\n"
                        + "where AccountName like ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String title = rs.getString("Title");
                    String Status = rs.getString("Status");
                    String content = rs.getString("Content");
                    int menteeID = rs.getInt("MenteeID");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    Request req = new Request(ID, title, Status, content, menteeID, deadlineDate, deadlineHour);
                    list.add(req);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Request> searchRequestByAccountNamePagination(String keyword, int start, int total) {
        Connection cn = null;
        ArrayList<Request> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Request.ID,Title, Status,Content, MenteeID, DeadlineDate, DeadlineHour, CreatedDate \n"
                        + "from Request join Account on MenteeID = Account.ID\n"
                        + "where AccountName like ?\n"
                        + "order by ID asc\n"
                        + "OFFSET ? rows\n"
                        + "fetch next ? rows only";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                pst.setInt(2, start);
                pst.setInt(3, total);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String title = rs.getString("Title");
                    String Status = rs.getString("Status");
                    String content = rs.getString("Content");
                    int menteeID = rs.getInt("MenteeID");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    Request req = new Request(ID, title, Status, content, menteeID, deadlineDate, deadlineHour);
                    list.add(req);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Request getARequestDetail(int requestID) {
        Connection cn = null;
        Request req = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from Request\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, requestID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int ID = rs.getInt("ID");
                    String title = rs.getString("Title");
                    String Status = rs.getString("Status");
                    String content = rs.getString("Content");
                    int menteeID = rs.getInt("MenteeID");
                    Date deadlineDate = rs.getDate("DeadlineDate");
                    int deadlineHour = rs.getInt("DeadlineHour");
                    req = new Request(ID, title, Status, content, menteeID, deadlineDate, deadlineHour);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return req;
    }

    public static Date getCreatedDateByRequestID(int requestID) {
        Connection cn = null;
        Date date = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select CreatedDate\n"
                        + "from Request\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, requestID);
                ResultSet rs = pst.executeQuery();
                if(rs!=null && rs.next())
                    date = rs.getDate("CreatedDate");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
