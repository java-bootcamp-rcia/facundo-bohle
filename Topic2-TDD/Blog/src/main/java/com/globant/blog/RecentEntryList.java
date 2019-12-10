package com.globant.blog;

import com.globant.entry.Entry;
import java.util.ArrayList;
import java.util.List;

public class RecentEntryList {

  List<Entry> list= new ArrayList<>();

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

  public Entry printList() {
    for (int i = (list.size()-1); i >= 0; i--) {
      list.get(i).printEntry();
    }
    return list.get(list.size()-1);
  }

}
