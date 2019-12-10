/**
 * DBAccessor is a mock class which represents what would be a real accessor in a further version of the system.
 * @deprecated will be overridden in the future
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */


package com.globant.database;

import com.globant.entry.Entry;

public class DBAccessor {


  public boolean connect() {
    return true;
  }

  public boolean executeDataRead(Entry entry){
    System.out.println("Connecting to the Database...");
    return true;
  }

  public boolean executeDataSet(Entry entry) {
    return true;
  }
}
