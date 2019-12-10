package com.globant.blog;

import com.globant.database.DBAccessor;
import com.globant.entry.Entry;
import com.globant.factory.EntryFactory;
import java.util.Scanner;

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

  public void showRecentEntries() {
    if (recent.getList().size()>0) {
      recent.printList();
    } else {
      System.out.println("No entry added yet");
    }
  }

}
