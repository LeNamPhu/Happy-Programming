/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Rating;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RateDAO {

    public static double getRateStar(int mentorID) {
        Connection cn = null;
        double Rate = 0.0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select avg(Rate) as StarRating\n"
                        + "from Rating\n"
                        + "where MentorID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, mentorID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    Rate = rs.getDouble("StarRating");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Rate;
    }

    public static String getRateComment(int mentorID) throws SQLException {
        String rateComment = "";
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT Comment FROM Rating "
                        + "WHERE MentorID = ?";
                stm = cn.prepareStatement(sql);
                stm.setInt(1, mentorID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    rateComment = rs.getString("Comment");
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
            if (cn != null) {
                cn.close();
            }
        }
        return rateComment;
    }

    public void insertRate(int mentorID, int menteeID, int rate, String comment) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "INSERT INTO RATING(Rate, Comment, MenteeID, MentorID) VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, rate);
                stm.setString(2, comment);
                stm.setInt(3, menteeID);
                stm.setInt(4, mentorID);
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

    public double getStar(int mentorID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        double star = 0;
        int count = 0;
        int sum = 0;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "SELECT Rate FROM Rating WHERE MentorID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, mentorID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    sum = sum + rs.getInt("Rate");
                    count++;
                }
                star = sum / count;
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
        return star;
    }

    public static ArrayList<Rating> listRating(int id) {
        ArrayList<Rating> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Rating where MentorID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int ID = rs.getInt("ID");
                        double rate = rs.getDouble("Rate");
                        String comment = rs.getString("Comment");
                        int MenteeID = rs.getInt("MenteeID");
                        int MentorID = rs.getInt("MentorID");
                        Rating rating = new Rating(ID, rate, comment, MenteeID, MentorID);
                        list.add(rating);
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
