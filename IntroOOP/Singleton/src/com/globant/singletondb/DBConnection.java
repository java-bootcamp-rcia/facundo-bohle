package com.globant.singletondb;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
  // Only instance of the class, according to the Singleton pattern
  private static DBConnection instance= new DBConnection();

  // Connection Data
  private String url = "jdbc:mysql://localhost:3306/testdb";
  private String username = "root";
  private String password = "admin";
  private Connection connection;

  // Constructor is private to avoid further instantiating
  private DBConnection(){};

  // Retrieves the instance for the Test
  public static DBConnection getInstance() {
    return instance;
  }

  // Retrieves the Connection
  public Connection getConnection() {
    try {
      if (this.connection==null) {
        this.connection= DriverManager.getConnection(url,username,password);
      }
    } catch(Exception e) {
      System.out.println("Fatal Error Trying to Connect: "+e);
      System.out.print(e.getMessage());
    }

    return connection;
  }
}
