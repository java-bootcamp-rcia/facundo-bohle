package com.globant;

import java.util.ArrayList;
import java.util.List;


  public class RecentFileList {

    private List<String> recentList= new ArrayList<>();

    public boolean open(String...fileURLs) {
      for (String fileURL: fileURLs) {
        open(fileURL);
      }
      return true;
    }

    public boolean open(String fileURL) {

      if (isDuplicated(fileURL)) {
         int index=recentList.indexOf(fileURL);
         recentList.remove(index);
      }

      if (recentList.size()==15) {
        recentList.remove(0);
      }

      recentList.add(fileURL);

      return true;
    }

    public List getList() {
      return recentList;
    }

    // Prints the Recent Files List and returns newest file
    public String printList() {
      int newestIndex= recentList.size()-1;

      for (int i= newestIndex ; i>=0  ; i--)
        System.out.println(recentList.get(i));

      return recentList.get(newestIndex);
    }

    private boolean isDuplicated(String fileURL) {
      if(recentList.indexOf(fileURL)!= -1)
        return true;
      return false;
    }
}
