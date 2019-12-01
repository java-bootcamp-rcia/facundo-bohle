package com.globant.singletondb;
import java.sql.SQLException;
import java.util.logging.Logger;

// Runnable Class
public class DBConnectionDemo {
  public static void main (String[] args) {
    Logger log= Logger.getLogger(DBConnectionDemo.class.getName());

    // Gets the only connection available
    DBConnection conn= DBConnection.getInstance();
    log.info("Instance of Connection Successfully Retrieved.");

    // Tries to retrieve the connection (Will fail as it's not a real database)
    try {
      if (conn.getConnection()==null) {
        throw new SQLException("Connection Lost");
      } else {
        log.info("Connection Successfully Established.");
      }
    } catch (Exception e){
      log.info("Connection Failed.");
    }
  }
}
