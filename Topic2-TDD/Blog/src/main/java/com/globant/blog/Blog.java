/**
 * Blog is an entity that represents an individual Blog object, which is the primary platform on
 * which the software operates. Serves as a proxy to the entryFactory {@link com.globant.factory.EntryFactory} (fordwars data),
 * and contains all the relevant info of an users' blog.
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.blog;

import com.globant.database.DBAccessor;
import com.globant.entry.Entry;
import com.globant.factory.EntryFactory;

public class Blog {

  static int idCount=0;
  private int id;
  private String name;
  private RecentEntryList recent= new RecentEntryList();
  private EntryFactory factory= EntryFactory.getInstance();
  private DBAccessor accessor= new DBAccessor();

  public Blog(String name) {
    id=++idCount;
    this.name=name;
  }


  /**
   * When the user calls to add a new entry, this is the method which the system interacts with.
   * The rest of the building process is hidden from the client.
   * @return the {@link com.globant.entry.Entry} subclass implementation which was just added
   * @param type is the user indicated type of Entry
   * @param title is the user indicated Entry Title
   * @param content is the video or text content
   * @since 1.0
   */
  public Entry add(String type, String title, String content) {
    Entry entry=factory.newEntry(id,accessor,type,title,content);
    recent.add(entry);
    return entry;
  }

  public int getId() {
    System.out.println("This blogs' id is: "+id);
    return id;
  }

  public String getName() {
    return name;
  }

  public EntryFactory getFactory() {
    return EntryFactory.getInstance();
  }


  /**
   * prints a listing of all the last 10 recent entries from newest to oldest
   * @return void
   * @since 1.0
   */
  public void showRecentEntries() {
    if (recent.getList().size()>0) {
      recent.printList();
    } else {
      System.out.println("No entry added yet");
    }
  }

}
