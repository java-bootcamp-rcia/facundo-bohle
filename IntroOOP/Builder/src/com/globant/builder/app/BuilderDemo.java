/**
 * BuilderDemo serves as an application class to run and test the creation and implementation
 * of a {@link com.globant.builder.connection.ConnectionBuilder} instance
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.builder.app;
import com.globant.builder.connection.ConnectionBuilder;
import com.globant.builder.connection.DBConnection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class BuilderDemo {


  public static void main(String[] args) throws SQLException {
    Logger log= Logger.getLogger(BuilderDemo.class.getName());

    // Creates a new Builder
    log.info("Creating new MYSQL Builder...");
    ConnectionBuilder mysqlBuilder= new ConnectionBuilder("MYSQL");
    log.info("New "+mysqlBuilder.getProtocol()+" Builder created");

    // Creates new Connection
    log.info("Creating new "+mysqlBuilder.getProtocol()+" Connection");
    DBConnection conn= mysqlBuilder.newConnection();

    //
    log.info("Successfully tried to create Connection.");

  }
}
