/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class ConnectDB {
    private final String userID = "root";
    private final String password = "nam13101999";

    public static void main(String[] args) throws Exception {
        ConnectDB db = new ConnectDB();
        System.out.println(db.getConnection());
    }
    
    public Connection getConnection()throws Exception {
         Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL
                    = "jdbc:mysql://localhost:3306/ptitshop?useSSL=false";
        return  DriverManager.getConnection(dbURL, userID, password);
    }
}
