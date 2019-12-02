package com.globant.builder.connection;

import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionBuilder {
  private Logger log= Logger.getLogger(ConnectionBuilder.class.getName());
  private String protocol;

  // Builds MYSQL Connections by default
  public ConnectionBuilder(String protocol) {
    this.protocol=protocol;
  }

  public DBConnection newConnection() throws SQLException {
    log.info("Creating Connection....");
    DBConnection conn= new DBConnection();
    conn.authenticate();
    conn.connect();
    log.info("Done.");
    return conn;
  }

  //
  public void getConnection() {
    log.info("Retrieving existing Session...");
    // Here it should find and existing connection in a real DB and retrieve it accordingly.
    log.info("Done.");
  }

  public String getProtocol() {
    return this.protocol;
  }

}
