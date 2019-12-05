/**
 * MySQLFactory represents a {@link com.globant.abstractfactory.factory.SQLFactory} entity
 * which produces  MySQL type connections to external dependencies.
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.abstractfactory.factory;
import com.globant.abstractfactory.connection.MySQL;
import com.globant.abstractfactory.connection.SQLConnection;

public class MySQLFactory extends SQLFactory {

  /**
   * @return a {@link com.globant.abstractfactory.connection.MySQL} instance object
   * @since 1.0
   */
  @Override
  public SQLConnection getConnection() {
    return new MySQL();
  }
}
