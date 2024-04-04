/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Database {

    public static Connection connectDB() {
    try {
        //Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospital", "root", "root");
        return connect;
    } catch (Exception e) {
        System.out.println("Error connecting to the database: " + e);
    }
    return null;
}


}
