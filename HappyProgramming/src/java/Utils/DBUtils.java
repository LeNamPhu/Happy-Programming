/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DBUtils {

    public static Connection makeConnection() throws  ClassNotFoundException, SQLException{
//        Connection conn = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databasename=HappyProgramming";
//        conn = DriverManager.getConnection(url, "sa", "Mashe3012");
//        return conn;
Connection cn = null;
        String IP = "localhost";
        String instanceName = "LAPTOP-G9SL61KO";
        String port = "1433";
        String uid = "sa";
        String pwd = "Mashe3012";
        String db = "HappyProgramming";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn;
    }

}
