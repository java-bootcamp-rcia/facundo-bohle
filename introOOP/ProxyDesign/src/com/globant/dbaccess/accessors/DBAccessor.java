/**
 * DBAccessor Interface serves as an entity to declare the common behavior of every
 * Accessor type described in this application.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.dbaccess.accessors;
import java.sql.SQLException;
import java.sql.Statement;

public interface DBAccessor {

  /**
   * @param url a DB url type e.g. jdbc:mysql:localhost:3066/mydb
   * @param username a DB valid username
   * @param password a DB valid password
   * @throws java.sql.SQLException when database is a Mock or cannot be accessed
   * @return always true, due to its Mock condition
   * @since 1.1
   */
  boolean connect(String url, String username, String password) throws SQLException;

  /**
   * Gets information from an external DB Dependency
   * @param querys is an array of query Statements to be passed to the DB
   * @return true
   * @since 1.1
   */
  boolean executeDataRead(Statement[] querys);

  /**
   * Attaches information to an external DB dependency
   * @param querys is an array of query Statements to be passed to the DB
   * @return true
   * @since 1.1
   */
  boolean executeDataSet(Statement[] querys);
}
