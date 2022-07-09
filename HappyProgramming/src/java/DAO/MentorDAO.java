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

    public static ArrayList<Mentor> mentorPagination(int start, int total) {
        ArrayList<Mentor> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Mentor\n"
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
                        String Job = rs.getString("Job");
                        String Introduction = rs.getString("Introducton");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction);
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

    public ArrayList<String> getListNameMentor(ArrayList<Integer> listMentorID) throws SQLException {
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
                    if (rs.next()) {
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

    public ArrayList<Mentor> viewAllMentor() {

        ArrayList<Mentor> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Mentor";
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
                        String Job = rs.getString("Job");
                        String Introduction = rs.getString("Introducton");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction);
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

    public static int getMentorRoleID(int mentorID) {
        Connection cn = null;
        int role = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select RoleID\n"
                        + "from Account join Mentor on Account.ID = Mentor.ID\n"
                        + "where Mentor.ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, mentorID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    role = rs.getInt("RoleID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public static boolean changeMentorStatus(int roleID, int mentorID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Account\n"
                        + "set RoleID = ?\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, roleID);
                pst.setInt(2, mentorID);
                pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static String getMentorAccountNameById(int id) {
        Connection cn = null;
        String accountName = "";
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select AccountName\n"
                        + "from Mentor join Account on Mentor.ID = Account.ID\n"
                        + "where Mentor.ID = ?";
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

    public static ArrayList<Mentor> searchMentorByAccountName(String keyword) {
        Connection cn = null;
        ArrayList<Mentor> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Mentor.ID, Email, FullName,AccountName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc,AchievementDesc,Framework,Avatar,Job,Introducton\n"
                        + "from Account join Mentor on Account.ID = Mentor.ID\n"
                        + "where AccountName like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
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
                    String Job = rs.getString("Job");
                    String Introduction = rs.getString("Introducton");
                    Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction);
                    list.add(mtr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Mentor> searchMentorByAccountNamePagination(String keyword, int start, int total) {
        Connection cn = null;
        ArrayList<Mentor> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Mentor.ID, Email, FullName,AccountName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc,AchievementDesc,Framework,Avatar,Job,Introducton\n"
                        + "from Account join Mentor on Account.ID = Mentor.ID\n"
                        + "where AccountName like ?\n"
                        + "order by Mentor.ID asc \n"
                        + "	OFFSET ? rows\n"
                        + "	fetch next ? rows only;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                pst.setInt(2, start);
                pst.setInt(3, total);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
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
                    String Job = rs.getString("Job");
                    String Introduction = rs.getString("Introducton");
                    Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction);
                    list.add(mtr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public ArrayList<Mentor> getSuggestionMentor(ArrayList<Integer> reqSkill) throws SQLException {
        ArrayList<Mentor> suggestionMentor = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                for (Integer skill : reqSkill) {
                    String sql = "SELECT MentorID FROM MentorSkill WHERE SkillID=? ";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, skill);
                    rs = stm.executeQuery();
                    while (rs.next()) {
                        if (!suggestionMentor.isEmpty()) {
                            for (Mentor mentor : suggestionMentor) {
                                if (mentor.getId() != rs.getInt("MentorID")) {
                                    suggestionMentor.add(getMentorByID(rs.getInt("MentorID")));
                                }
                            }
                        } else {
                            suggestionMentor.add(getMentorByID(rs.getInt("MentorID")));
                        }

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
        return suggestionMentor;
    }

    public Mentor getMentorByID(int mentorID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Mentor mentor = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT FullName, ServiceDesc, Avatar FROM Mentor WHERE ID=? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, mentorID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    mentor = new Mentor(mentorID, rs.getString("FullName"), rs.getString("ServiceDesc"), rs.getString("Avatar"));
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
        return mentor;
    }

}
