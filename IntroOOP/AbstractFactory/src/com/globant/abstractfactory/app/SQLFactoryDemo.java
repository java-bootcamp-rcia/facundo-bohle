/**
 * SQLFactoryDemo serves as an application class to run and test the production
 * and implementation of {@link com.globant.abstractfactory.factory.SQLFactory} type extended objects.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.abstractfactory.app;
import com.globant.abstractfactory.connection.SQLConnection;
import com.globant.abstractfactory.factory.FactoryProducer;
import com.globant.abstractfactory.factory.SQLFactory;
import java.util.logging.Logger;

public class SQLFactoryDemo {

  public static void main(String[] args) {

    Logger log = Logger.getLogger(SQLFactoryDemo.class.getName());

    //*** MYSQL ***//

    // Gets a MySQL Factory
    SQLFactory mySQLFact= FactoryProducer.getFactory("MYSQL");

    // Produces a MySQL Connection
    SQLConnection mySQLConn= mySQLFact.getConnection();

    // Tests the new MySQL connection
    log.info("NEW MYSQL CONNECTION");
    mySQLConn.connect();



    //*** POSTGRESQL ***//

    // Gets a PostgreSQL Factory
    SQLFactory postgreSQLFact= FactoryProducer.getFactory("PostgreSQL");

    // Produces a PostgreSQL Connection
    SQLConnection postgreSQLConn= postgreSQLFact.getConnection();

    // Tests the new PostgreSQL Connection
    log.info("NEW POSTGRESQL CONNECTION");
    postgreSQLConn.connect();

  }
}
