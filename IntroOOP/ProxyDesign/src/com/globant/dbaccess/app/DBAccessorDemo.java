package com.globant.dbaccess.app;
/**
 * DBAcessorDemo serves as an application class to run and test the Proxy Designed DBAccessor scheme
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
import com.globant.dbaccess.accessors.DBAccessor;
import com.globant.dbaccess.accessors.ProxyAccessor;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBAccessorDemo {

  public static void main(String[] args) throws SQLException {
    Logger log= Logger.getLogger(DBAccessorDemo.class.getName());

    // Creates a proxy of a MySQL DB Accesor
    String protocol="MYSQL";
    log.info("Creating a.. "+protocol+" DB Accesor");
    DBAccessor accessor= new ProxyAccessor(protocol);

    // Checks connection (Will fail as It's a Mock DB)
    accessor.connect("jdbc:mysql://localhost:5432/jdbc", "root","admin");

    // Executes DataSet
    accessor.executeDataSet(null);

    // Executes DataRead
    accessor.executeDataRead(null);
  }
}
