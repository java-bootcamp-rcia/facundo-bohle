/**
 * PostgreSQLAccessor serves a DataAccessor for Postgre DB external dependencies
 * For more info on the methods, see {@link com.globant.dbaccess.accessors.DBAccessor} Interface
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.dbaccess.accessors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class PostgreSQLAccessor implements DBAccessor {

  private String protocol= "postgresql";
  private Connection connection;
  Logger log= Logger.getLogger(MySQLAccessor.class.getName());

  /**
   * @return true
   * @since 1.0
   */
  @Override
  public boolean connect(String url, String username, String password) throws SQLException {
    log.info("Connecting to a "+protocol+" based DB...");
    this.connection= DriverManager.getConnection(url, username, password);
    return true;
  }

  /**
   * @return true
   * @since 1.0
   */
  @Override
  public boolean executeDataSet(Statement[] querys){
    log.info("Executing DataSet to "+protocol+" based DB...");
    /*
     *       Executes the DataSet with the corresponding
     *       Statements in PostgreSQL Syntax.
     */
    return true;
  }

  /**
   * @return true
   * @since 1.0
   */
  @Override
  public boolean executeDataRead(Statement[] querys) {
    log.info("Executing DataRead to "+protocol+" based DB...");
    /*
     *       Executes the DataSet with the corresponding
     *       Statements in PostgreSQL Syntax.
     */
    return true;
  }

}
