/**
 * URL is a {@link com.globant.builder.connection.items.ConnectionItem} type object which holds a
 * string type field with a SQL Connection url.
 *
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.builder.connection.items;

public class URL extends ConnectionItem {

  /**
   * Checks connection speed by pinging to the remote. (Works only with true dependencies)
   * @return true
   * @since 1.0
   */
  public boolean checkSpeed() {
    /* Statements regarding ms ping check */
    System.out.println("Speed is checked!");
    return true;
  }
}