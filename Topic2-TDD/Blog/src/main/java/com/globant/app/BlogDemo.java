/**
 * BlogDemo is a class which serves as an application to run the Blog Creator Software
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.app;
import static java.lang.System.out;

import com.globant.blog.Blog;
import com.globant.entry.Entry;
import java.util.Scanner;


public class BlogDemo {

  public static void main(String[] args) {

    Scanner s= new Scanner(System.in);

    out.println("*************Blog Demo**************");
    out.println("Use camelCase for inputs (no spaces)");
    out.println("");
    out.println("1. Create New Blog");
    out.print("Input: ");
    s.next();

    out.println("");
    out.print("Select a name for your blog: ");
    Blog blog= new Blog(s.next());

    out.println("");
    printOptions(blog);
    int option=s.nextInt();



    while (option!=3) {

      if (option == 1) {
        out.println("");
        out.print("What kind of new Entry? (Video/Text): ");
        String type= s.next();
        out.print("What title do you want?: ");
        String title= s.next();

        if ("Video".equalsIgnoreCase(type)) {
          out.print("Paste your video link: ");
        } else if ("Text".equalsIgnoreCase(type)) {
          out.print("Enter your text: ");
        }

        String content=s.next();

        Entry entry=blog.add(type,title,content);
        out.println("");
        out.println("\nSucessfully Added new Entry\n");
        out.println("");
        entry.printEntry();
        pressKeyToContinue();

      } else if (option == 2) {
        blog.showRecentEntries();
        pressKeyToContinue();
      }


      out.flush();
      printOptions(blog);
      option=s.nextInt();
    }
    System.out.println("Bye....");
  }

  /**
   * serves the purpose of printing a menu with options to the console
   * each time the user has to perform an action with his new blog.
   * @return void
   * @param blog is a unique Blog entity
   * @since 1.0
   */

  public static void printOptions(Blog blog) {
    out.println("-------------"+blog.getName()+"--------------");
    out.println("1. Create a New Entry");
    out.println("2. Show Recent entries list");
    out.println("3. Get Out");
  }

  /**
   * @throws Exception when a key other than Enter is pressd
   * @return void
   * @since 1.0
   */
  public static void pressKeyToContinue() {
    System.out.println("Press Enter key to continue...");
    try
    {
      System.in.read();
    }
    catch(Exception e)
    {}
  }



}
