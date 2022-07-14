package DAO;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.Skill;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 * @author DELL
 */
public class SkillDAO {

    public static ArrayList<Skill> getAllSkill() {
        Connection cn = null;
        ArrayList<Skill> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from Skill";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("Name");
                    String status = rs.getString("Status");
                    String image = rs.getString("image");
                    Skill sk = new Skill(ID, name, status, image);
                    list.add(sk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean changeStatus(String ID, String status) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Skill\n"
                        + "set Status = ?\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, status);
                pst.setString(2, ID);
                pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean addASkill(String name, String status, String image) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into Skill(Name,Status,image)\n"
                        + "values (?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, status);
                pst.setString(3, image);
                pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean updateASkill(String id, String name, String status, String image) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Skill\n"
                        + "set Name = ?, Status = ?, image = ?\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, status);
                pst.setString(3, image);
                pst.setString(4, id);
                pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static Skill getASkill(String id) {
        Connection cn = null;
        Skill sk = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select *\n"
                    + "from Skill\n"
                    + "where ID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String ID = rs.getString("ID");
                String name = rs.getString("Name");
                String status = rs.getString("Status");
                String image = rs.getString("image");
                sk = new Skill(ID, name, status, image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sk;
    }
    public static final String GET_LIST_SKILL = "SELECT Name, Status FROM Skill";

    public ArrayList<String> getListSkillName() throws SQLException {
        ArrayList<String> listSkill = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = GET_LIST_SKILL;
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if ("active".equals(rs.getString("Status"))) {
                        String name = rs.getString("Name");
                        listSkill.add(name);
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
        return listSkill;
    }

    public static int totalSkillsofRequests(int menteeID) {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Count(MenteeID) as TotalSkillOfRequest\n"
                        + "from RequestSkill join Request on RequestID = ID\n"
                        + "where MenteeID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menteeID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    result = rs.getInt("TotalSkillOfRequest");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void insertSkill(int mentorID, ArrayList<Integer> listId) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer integer : listId) {
                    String sql = "INSERT INTO MentorSkill(SkillID, MentorID) VALUES(?,?)";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, integer);
                    stm.setInt(2, mentorID);
                    stm.executeUpdate();
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
    
    public void deleteSkill(int mentorID) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                    String sql = "DELETE MentorSkill WHERE MentorID=?";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, mentorID);
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
}
