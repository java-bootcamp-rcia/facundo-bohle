/**
 * Password is a {@link com.globant.builder.connection.items.ConnectionItem} type object which holds a
 * string type field with a SQL Connection password.
 *
 *
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */


package com.globant.builder.connection.items;


public class Password extends ConnectionItem {

  /**
   * Encrypts a Connection password
   * @return true
   * @since 1.1
   */
  public boolean encrypt() {
    System.out.println("Encrypting Password...");
    /* Statements regarding Encryption*/
    System.out.print("Done.");
    return true;
  }
}