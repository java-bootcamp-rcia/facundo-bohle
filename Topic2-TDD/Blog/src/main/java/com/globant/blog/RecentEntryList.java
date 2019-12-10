/**
 * RecentEntryList serves as a storage and visualization tool for the last added entries to an user's blog.
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.blog;

import com.globant.entry.Entry;
import java.util.ArrayList;
import java.util.List;

public class RecentEntryList {

  List<Entry> list= new ArrayList<>();

  /**Adds a new member to the list. Deletes the oldest given there's more than 10 in queue.
   * @return void
   * @param entry new blog entry, implementation of {@link com.globant.entry.Entry}
   * @since 1.0
   */
  public void add (Entry entry) {
    if (list.size() == 10) {
      list.remove(0);
    }
      list.add(entry);
  }

  public void setList(List<Entry> list) {
    this.list = list;
  }

  public List<Entry> getList() {
    return list;
  }

  /**
   * Prints a listing of the last 10 entries from newest to oldest.
   * In order to do so, it iterates an {@link java.util.ArrayList} backwards.
   * @return the newest entry {@link com.globant.entry.Entry} object which was added
   * @since 1.0
   */
  public Entry printList() {
    for (int i = (list.size()-1); i >= 0; i--) {
      list.get(i).printEntry();
    }
    return list.get(list.size()-1);
  }

}
