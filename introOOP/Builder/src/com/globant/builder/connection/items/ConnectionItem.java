/**
 * <p>
 *  ConnectionItem represents an entity of an ingredient neccesary in a
 * {@link java.sql.Connection} type object. A connection item can be a:
 *  <ul>
 *    <li> Database URL</li>
 *    <li> Username</li>
 *   <li> Password</li>
 *  </ul>
 * </p>
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.builder.connection.items;

import java.util.Scanner;

public abstract class ConnectionItem {

  protected String value="";

  /**
   * @return a String type object containing information about the item's value
   * @since 1.1
   */
  public String getValue() {
    if (this.value.equals("")) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a valid"+this.getClass().getName());
      this.value = input.nextLine();
    }
    return this.value;
  }
}
