/**
 * TextEntry is a specialization of {@link com.globant.entry.Entry}
 * and provides behavior for the management of Text type inputs
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.entry;

public class TextEntry extends Entry {

  private String text;

  public TextEntry(int blogId) {
    super(blogId);
  }


  public void writeText(String text) {
    this.text=text;
  }

  void addSubtitle(String subtitle){
    text+="<h1>"+subtitle+"</h1>\n";
  }

  void addLink(String placeholder, String link) {
    text+="<a href='"+link+"'>"+placeholder+"</a>";
  }

  public String getText() {
    return text;
  }

  /**
   * Specialization of method {@link com.globant.entry.Entry}.printEntry() but adds the text
   * content at the end.
   * @return true, after the listing had been printed
   * @since 1.0
   */
  @Override
  public boolean printEntry() {
    super.printEntry();
    System.out.println("Content: ");
    System.out.println(text);
    return true;
  }
}
