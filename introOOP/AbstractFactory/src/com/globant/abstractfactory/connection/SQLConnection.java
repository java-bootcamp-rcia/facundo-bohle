/**
 * SQLConnection represents a connection to an external DB dependency.
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.abstractfactory.connection;


public interface SQLConnection {
  /**
   * @return always true, since it only mocks a real connection
   * @since 1.1
   */
  boolean connect();
}
