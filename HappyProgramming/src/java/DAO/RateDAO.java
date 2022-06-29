/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
