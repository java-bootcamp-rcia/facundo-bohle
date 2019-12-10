/**
 * EntryFactory is an entity which follows the Factory Design Pattern for the production
 * and storage of Entry type objects
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.factory;

import com.globant.database.DBAccessor;
import com.globant.entry.*;



public class EntryFactory {

  private static EntryFactory instance= new EntryFactory();


  private EntryFactory() {}



  public static EntryFactory getInstance() {
    return instance;
  }

  /**
   * Produces and stores {@link com.globant.entry.Entry} type objects to an user's blog
   * @throws java.sql.SQLException when the DB can not be accessed
   * @return the last added {@link com.globant.entry.Entry}
   * @param blogId id of the new entry's blog
   * @param accessor database management acessor object
   * @param entryData An array with the data that the user inputs in {@link com.globant.app.BlogDemo} implementation
   * @since 1.0
   */
  public Entry newEntry(int blogId, DBAccessor accessor,String...entryData) {
    Entry entry = null;

    if ("Video".equalsIgnoreCase(entryData[0])) {
     entry = new VideoEntry(blogId);
     ((VideoEntry) entry).embedVideo(entryData[2]);

    } else if("Text".equalsIgnoreCase(entryData[0])) {
     entry = new TextEntry(blogId);
     ((TextEntry) entry).writeText(entryData[2]);
    }

    entry.setType(entryData[0]);
    entry.setTitle(entryData[1]);
    save(entry,accessor);
    return entry;
  }

  /**
   * Stores the entry in a remote DB dependency
   * @throws java.sql.SQLException when the DB dependency can not be accessed
   * @return  true, after saving
   * @param entry an entry {@link com.globant.entry.Entry} type object
   * @param accessor database management acessor object
   * @since 1.0
   */
  public boolean save(Entry entry, DBAccessor accessor) {
    return accessor.executeDataRead(entry);
  }

}
