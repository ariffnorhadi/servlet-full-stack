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
 */
public class UserDAO {

  private Connection connection = null;

  public UserDAO() throws ClassNotFoundException {
    connection = DBConnection.getConnection();
  }

  public void insertUser(User user) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("insert into users(full_name, email, password) values(?, ?, ?)");

      preparedStatement.setString(1, user.getFullName());
      preparedStatement.setString(2, user.getEmail());
      preparedStatement.setString(3, user.getPassword());

      preparedStatement.executeUpdate();
    } catch (SQLException error) {
      error.printStackTrace();
    }
  }

}
