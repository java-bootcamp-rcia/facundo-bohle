/**
 * FactoryProducer is a class which serves as an static platform to instantiate factories extended from
 * {@link com.globant.abstractfactory.factory.SQLFactory} of different
 * {@link com.globant.abstractfactory.connection.SQLConnection} Type connections.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.abstractfactory.factory;
public class FactoryProducer {

  /**
   * @param factoryType is a protocol for a type of SQL Factory e.g Oracle, Postgre, etc.
   * @return a {@link com.globant.abstractfactory.factory.SQLFactory} subclass instance
   * @since 1.0
   */
  public static SQLFactory getFactory(String factoryType) {
    if ("MYSQL".equalsIgnoreCase(factoryType)) {
      return new MySQLFactory();
    } else if ("PostgreSQL".equalsIgnoreCase(factoryType)) {
      return new PostgreSQLFactory();
    }
    return null;
  }
}
