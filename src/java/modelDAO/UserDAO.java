/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author ariffnorhadi
 * 
 * UserDAO is a Data Access Object (DAO) class for managing user-related
 * database operations. This class uses connection to the DB that's provided by
 * DBConnection.java (servlet-full-stack\src\java\database\DBConnection.java)
 */
public class UserDAO {

  // Database connection object
  private Connection connection = null;

  public UserDAO() throws ClassNotFoundException {

    // whenever this class is intantiated, we also want to start establish the DB connection, then just call the method that we write here
    connection = DBConnection.getConnection();
  }

  // This method is to insert data into table.
  public void insertUser(User user) {
    try {

      // Use PreparedStatement to prepare our SQL. ? means parameter that we will set later.
      // Warning: Make sure the SQL is correct. Can test whether it will work on phpmyadmin.
      PreparedStatement preparedStatement = connection.prepareStatement("insert into users(full_name, email, password) values(?, ?, ?)");

      // Set the value for each param.
      preparedStatement.setString(1, user.getFullName());
      preparedStatement.setString(2, user.getEmail());
      preparedStatement.setString(3, user.getPassword());

      // Run the SQL
      preparedStatement.executeUpdate();
    } catch (SQLException error) {
      error.printStackTrace();
    }
  }
  
  // This method also insert data into table.
  public void insertUserData(String fullName, String email, String password){
      try {
      PreparedStatement preparedStatement = connection.prepareStatement("insert into users(full_name, email, password) values(?, ?, ?)");

      preparedStatement.setString(1, fullName);
      preparedStatement.setString(2, email);
      preparedStatement.setString(3, password);

      preparedStatement.executeUpdate();
    } catch (SQLException error) {
      error.printStackTrace();
    }
  }

}
