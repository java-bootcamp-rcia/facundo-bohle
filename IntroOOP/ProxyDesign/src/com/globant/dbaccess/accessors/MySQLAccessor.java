package com.globant.dbaccess.accessors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class MySQLAccessor implements DBAccessor {

  // Session Data
  private String protocol= "mysql";
  private Connection connection;
  Logger log= Logger.getLogger(MySQLAccessor.class.getName());

  // Accessing Methods
  @Override
  public void connect(String url, String username, String password) throws SQLException {
    log.info("Connecting to a "+protocol+" based DB...");
    this.connection=DriverManager.getConnection(url, username, password);    // Establishes Connection
  }

  @Override
  public void executeDataSet(Statement[] querys){
    log.info("Executing DataSet to "+protocol+" based DB...");
    /*
     *       Executes the DataSet with the corresponding
     *       Statements in MySQL Syntax.
     */
  }

  @Override
  public void executeDataRead(Statement[] querys) {
    log.info("Executing DataRead to "+protocol+" based DB...");
    /*
     *       Executes the DataSet with the corresponding
     *       Statements in MySQL Syntax.
     */
  }


}
