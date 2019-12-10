/**
 * Entry is a generalization of a Blog entry which serves the purpose of being a common ground for
 * {@link com.globant.entry.TextEntry} and {@link com.globant.entry.VideoEntry} implementations
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */


package com.globant.entry;

import java.time.LocalDateTime;

public class Entry {

  public static int entryCount=0;
  private int blogId;
  private int id;
  private String type;
  private String title;
  private LocalDateTime creationDate;


  public Entry(int blogId) {
    this.id=++entryCount;
    this.blogId=blogId;
    creationDate = LocalDateTime.now();
  }


  /**
   * Prints a listing with all the data about an unique {@link com.globant.entry.Entry} implementation
   * @return true after the listing has been printed
   * @since 1.0
   */
  public boolean printEntry() {
    System.out.println("Created: "+creationDate);
    System.out.println("title: "+title);
    System.out.println("Blog Id: "+blogId);
    System.out.println("Entry Id: "+id);
    System.out.println("type: "+type);
    return true;
  }


  public int getId() {
    return id;
  }

  public void setType(String type) {
    this.type = type;
  }


  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

}
