/**
 * SQLFactory is an abstract class entity which serves as a model to instantiate factories
 * of DB external dependencies with a certain protocol (SQL,Oracle,PostGre,etc)
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.abstractfactory.factory;
import com.globant.abstractfactory.connection.SQLConnection;

public abstract class SQLFactory {

  /**
   * @return a {@link com.globant.abstractfactory.connection.SQLConnection} instance object
   * @since 1.0
   */
  public abstract SQLConnection getConnection() ;
}
