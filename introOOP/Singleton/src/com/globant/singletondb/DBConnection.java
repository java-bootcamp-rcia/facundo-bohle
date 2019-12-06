/**
 *  DBConnection is the main entity we'll be using to generate connections
 *  to our corresponding Databases.
 *  It makes uses of two java.sql package classes, please see the {@link java.sql.Connection} and
 *  {@link java.sql.DriverManager} classes for more documentation info.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.singletondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  private static DBConnection instance= new DBConnection();

  private String url = "jdbc:mysql://localhost:3306/testdb";
  private String username = "root";
  private String password = "admin";
  private Connection connection;



  private DBConnection(){};

  /**
   * @return an instance of this class
   * @since 1.0
   */
  public static DBConnection getInstance() {
    return instance;
  }

  /**
   *
   * @throws {@link java.sql.SQLException} the database is a Mock or cannot be accessed
   * @return always true due to the external dependency (DB) being a mock. Expected to throw an exception
   * @since 1.1
   */
  public boolean getConnection() throws SQLException {
    try {
      if (this.connection==null) {
        this.connection= DriverManager.getConnection(url,username,password);
        throw new SQLException();
      }
    } catch(SQLException e) {
      System.out.println("Fatal Error Trying to Connect: ");
      e.printStackTrace();
    }
    return true;
  }
}
