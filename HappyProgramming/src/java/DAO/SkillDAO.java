/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Skill;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
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
            if(rs!=null && rs.next()) {
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
}
