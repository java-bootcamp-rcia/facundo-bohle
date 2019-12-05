/**
 *  DBConnectionDemo serves as an application class to run and test a {@link com.globant.singletondb.DBConnection}
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.singletondb;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnectionDemo {
  public static void main (String[] args) {
    Logger log= Logger.getLogger(DBConnectionDemo.class.getName());

    // Gets the only connection available
    DBConnection conn= DBConnection.getInstance();
    log.info("Instance of Connection Successfully Retrieved.");

    // Tries to retrieve the connection (Will fail as it's not a real database)
    try {
        conn.getConnection();
        throw new SQLException("Connection Lost");
    } catch (Exception e){
      log.info("Connection Failed.");
    }
  }
}
