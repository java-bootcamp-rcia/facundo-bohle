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

  @Override
  public boolean printEntry() {
    super.printEntry();
    System.out.println("Content: ");
    System.out.println(text);
    return true;
  }
}
