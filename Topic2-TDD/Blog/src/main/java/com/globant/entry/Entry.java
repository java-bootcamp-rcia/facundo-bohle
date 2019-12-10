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
