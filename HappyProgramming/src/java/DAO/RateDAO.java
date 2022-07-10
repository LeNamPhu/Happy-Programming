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
                if(rs!=null && rs.next())
                    Rate = rs.getDouble("StarRating");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Rate;
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
                        String comment = rs.getString("Commnent");
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
