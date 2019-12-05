/**
 *  DBConnection is an entity which represents a SQL Connection.
 *  It contains a {@link java.sql.Connection} type object, as well as a
 *  {@link java.util.List} type array with metadata about the Connection.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.builder.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
  private List<ConnectionItem> connectionData= new ArrayList<>();
  private Connection connection;


  /**
   * Creates the necessary Connection items and attaches them to the current Connection
   * @return void
   * @since 1.0
   */
  public void getConnectionDetails() {
    if (connectionData.isEmpty()) {
      try {
        System.out.println("Authenticating Session Details......");
        // Creates Connection Items
        URL url = new URL();
        Username user = new Username();
        Password pass = new Password();
        // Attaches info to the Session
        connectionData.add(0, url);
        connectionData.add(1, user);
        connectionData.add(2, pass);
      } catch (Exception e) {
        e.getMessage();
      }
    } else {
      System.out.println("Already authenticated.");
    }
  }

  /**
   * Passes the data stored in this.connectionData (ArrayList) to a {@link java.sql.Connection}
   * type instance, calling {@link java.sql.DriverManager}'s static method getConnection();
   * @return void
   * @since 1.0
   */
  public void connect() throws SQLException {
    System.out.println("Connecting...");
    try {
      if (connection.isClosed()) {
        this.connection = DriverManager.getConnection(connectionData.get(0).getValue(),
            connectionData.get(1).getValue(),
            connectionData.get(2).getValue());

      } else {
        System.out.println("Connection is Live.");
      }
    } catch (Exception e) {
      e.getMessage();
    }
    System.out.println("Done: Connection Established.");
  }

}
