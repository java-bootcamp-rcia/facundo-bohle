/**
 * <p>This class serves as an entity to represent
 * a real Recent File List which holds up to 15 most
 * recent files</p>
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant;
import java.util.ArrayList;
import java.util.List;


  public class RecentFileList {

    private List<String> recentList= new ArrayList<>();


    /**
     * @param fileURLs a collection Array of String type file URLS
     * @return true, once files had been added to the list
     * @since 1.0
     */
    public boolean open(String...fileURLs) {
      for (String fileURL: fileURLs) {
        open(fileURL);
      }
      return true;
    }


    /**
     * @param fileURL a String type file URL to be opened
     * @return true, once file has been added to the list
     * @since 1.0
     */
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

    /**
     *
     * @return a List<String> ArrayList containing the URL of the most recent opened files
     * @since 1.0
     */
    public List getList() {
      return recentList;
    }

    /**
     * @return a list of all the most recent files opened to the stdout
     * @since 1.0
     */
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
