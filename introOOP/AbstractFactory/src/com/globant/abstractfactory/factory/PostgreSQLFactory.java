/**
 * PostgreSQLFactory represents a {@link com.globant.abstractfactory.factory.SQLFactory} entity
 * which produces PostgreSQL type connections to external dependencies.
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.abstractfactory.factory;
import com.globant.abstractfactory.connection.PostgreSQL;
import com.globant.abstractfactory.connection.SQLConnection;


public class PostgreSQLFactory extends SQLFactory {

  /**
   * @return a {@link com.globant.abstractfactory.connection.PostgreSQL} instance object
   * @since 1.0
   */
  @Override
  public SQLConnection getConnection() {
    return new PostgreSQL();
  }
}
