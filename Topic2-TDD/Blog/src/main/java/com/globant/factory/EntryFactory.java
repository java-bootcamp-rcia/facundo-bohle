package com.globant.factory;

import com.globant.database.DBAccessor;
import com.globant.entry.Entry;
import com.globant.entry.TextEntry;
import com.globant.entry.VideoEntry;

public class EntryFactory {

  private static EntryFactory instance= new EntryFactory();


  private EntryFactory() {}


  public static EntryFactory getInstance() {
    return instance;
  }


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

  public boolean save(Entry entry, DBAccessor accessor) {
    return accessor.executeDataRead(entry);
  }

}
