/**
 * MySQL represents a connection to an external MySQL DB dependency.
 * For more info on its methods, check {@link com.globant.abstractfactory.connection.SQLConnection}
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.abstractfactory.connection;
import java.util.logging.Logger;


public class MySQL implements SQLConnection {

  private String userName;
  private String password;
  private String url;
  private String protocol= "mysql";


  private Logger log = Logger.getLogger(MySQL.class.getName());

  /**
   * @return true
   * @since 1.0
   */
  @Override
  public boolean connect(){
    log.info("Connecting to MYSQL Database...");
    log.info("Success: Connection to MySQL Established.");
    return true;
  }
}
