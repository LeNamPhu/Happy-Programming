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
    private static final String INSERTCV2 = "UPDATE Mentor SET Email =?, FullName=?, Address=?,DateofBirth=?, Sex=?, Job=?,Introducton=?,Profession=?,ProfessionIntro=?,"
            + "Framework=?,Service=?,ServiceDesc=?,AchievementDesc=?,Avatar=? WHERE ID=?"; // thêm cái này

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
                        String Service = rs.getString("Service");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction, Service);
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

    public static ArrayList<Mentor> viewAllMentor() {
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
                        String Service = rs.getString("Service");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction, Service);
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

    public ArrayList<Mentor> listMentor() {

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
                        String Service = rs.getString("Service");
                        Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction, Service);

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
                    String Service = rs.getString("Service");
                    Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction, Service);
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
                    String Service = rs.getString("Service");
                    Mentor mtr = new Mentor(ID, Email, FullName, Address, Phone, DateOfBirth, Sex, Profession, ProfessionIntro, ServiceDesc, AchievementDesc, Framework, Avatar, Job, Introduction, Service);
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

    public boolean insertcv(Mentor mentor) throws SQLException {  // cái này
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERTCV);
                stm.setString(1, mentor.getJob());
                stm.setString(2, mentor.getIntroduction());
                stm.setString(3, mentor.getProfession());
                stm.setString(4, mentor.getProfessionIntro());
                stm.setString(5, mentor.getFramework());
                stm.setString(6, mentor.getService());
                stm.setString(7, mentor.getServiceDesc());
                stm.setString(8, mentor.getAchievementDesc());
                stm.setString(9, mentor.getAvatar());
                stm.setInt(10, mentor.getId());

                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {

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

    public boolean insertcv2(Mentor mentor) throws SQLException {  // cái này
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement(INSERTCV2);
                stm.setString(1, mentor.getEmail());
                stm.setString(2, mentor.getFullname());
                stm.setString(3, mentor.getAddress());
                stm.setDate(4, mentor.getDob());
                stm.setString(5, mentor.getSex());
                stm.setString(6, mentor.getJob());
                stm.setString(7, mentor.getIntroduction());
                stm.setString(8, mentor.getProfession());
                stm.setString(9, mentor.getProfessionIntro());
                stm.setString(10, mentor.getFramework());
                stm.setString(11, mentor.getService());
                stm.setString(12, mentor.getServiceDesc());
                stm.setString(13, mentor.getAchievementDesc());
                stm.setString(14, mentor.getAvatar());
                stm.setInt(15, mentor.getId());

                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {

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

    public boolean getMentorProfession(int mentorID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        String profession = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("select Profession from Mentor where ID = ?");
                stm.setInt(1, mentorID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    profession = rs.getString("Profession");
                }
                if (profession != null) {
                    check = true;
                }

            }
        } catch (Exception e) {
        }
        return check;
    }

    public Mentor getMentorInfoByID(int mentorID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Mentor mentor = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Mentor WHERE ID=? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, mentorID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    mentor = new Mentor(mentorID, rs.getString("Email"), rs.getString("FullName"), rs.getString("Address"), rs.getString("Phone"), rs.getDate("DateOfBirth"), rs.getString("Sex"), rs.getString("Profession"), rs.getString("ProfessionIntro"), rs.getString("ServiceDesc"), rs.getString("AchievementDesc"), rs.getString("Framework"), rs.getString("Avatar"), rs.getString("Job"), rs.getString("Introducton"), rs.getString("Service"));
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

    public ArrayList<String> getmentorSKill(int mentorID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        ArrayList<String> skill = new ArrayList<>();
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "select * \n"
                        + "from MentorSKill m join Skill k on m.SkillID=k.ID\n"
                        + "where mentorID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, mentorID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String skillName = rs.getString("Name");
                    skill.add(skillName);

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
        return skill;
    }

    public static boolean compareSKill(String skill, String mentorSkill) {

        return skill.equals(mentorSkill);

    }

    public Integer getMentorIDByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int mentorID = 0;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT ID FROM Mentor WHERE FullName = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                rs = stm.executeQuery();
                if (rs.next()) {
                    mentorID = rs.getInt("ID");
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
        return mentorID;

    }
    public static String getAMentorAvatar(int id) {
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select Avatar\n"
                        + "from Mentor\n"
                        + "where ID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if(rs!=null && rs.next())
                    result = rs.getString("Avatar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
