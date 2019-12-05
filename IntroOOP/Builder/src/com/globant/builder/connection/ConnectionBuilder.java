/**
 *  ConnectionBuilder is a building entity which creates and/or gets
 *  {@link com.globant.builder.connection.DBConnection} type instances
 *  according to the Builder Design Pattern.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.builder.connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionBuilder {
  private Logger log= Logger.getLogger(ConnectionBuilder.class.getName());
  private String protocol;


  /**
   * Creates a new an SQL Builder
   * @param protocol type of SQL connection that must be built (e.g MySQL)
   * @return void
   * @since 1.0
   */
  public ConnectionBuilder(String protocol) {
    this.protocol=protocol;
  }

  /**
   * Creates a new SQL Connection
   * @throws SQLException when a connection fails
   * @return a {@link com.globant.builder.connection.DBConnection} type instance
   * @since 1.0
   */
  public DBConnection newConnection() throws SQLException {
    log.info("Creating Connection....");
    DBConnection conn= new DBConnection();
    conn.getConnectionDetails();
    conn.connect();
    log.info("Done.");
    return conn;
  }

  /**
   * Searches for an existing connection
   * @return true, as it's a mock. In a real implementation it'd return a {@link com.globant.builder.connection.DBConnection} type object
   * @since 1.1
   */
  public boolean getConnection() {
    log.info("Retrieving existing Session...");
    // Here it should find and existing connection in a real DB and retrieve it accordingly.
    log.info("Done.");
    return true;
  }

  /**
   * Returns the type of SQL connection which this builder creates
   * @return a String type protocol (e.g "MySQL","PostgreSQL")
   * @since 1.0
   */
  public String getProtocol() {
    return this.protocol;
  }

}
