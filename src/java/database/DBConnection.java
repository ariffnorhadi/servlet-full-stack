/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ariffnorhadi
 */
public class DBConnection {

  private static Connection myConnection = null;
  private static String myDbUrl = "jdbc:mysql://localhost:3306/full_stack_dev";

  DBConnection() {
  }

  public static Connection getConnection() throws ClassNotFoundException {
    if (myConnection != null) {
      return myConnection;
    } else {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        myConnection = DriverManager.getConnection(myDbUrl, "root", ""); // 2nd argument is username, 3rd argument is password.
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return myConnection;
  }

}
