/**
 * PostgreSQL represents a connection to an external PostgreSQL DB dependency.
 * For more info on its methods, check {@link com.globant.abstractfactory.connection.SQLConnection}
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.abstractfactory.connection;
import java.util.logging.Logger;

public class PostgreSQL implements SQLConnection {

  private String userName;
  private String password;
  private String url;
  private String protocol= "postgre";

  private Logger log= Logger.getLogger(PostgreSQL.class.getName());


  /**
   * @return true
   * @since 1.0
   */
  @Override
  public boolean connect(){
    log.info("Connecting to POSTGRESQL Database...");
    log.info("Success: Connection to PostgreSQL Established.");
    return true;
  }
}
