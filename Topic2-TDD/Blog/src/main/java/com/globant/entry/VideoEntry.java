package com.globant.entry;

public class VideoEntry extends Entry{

  private String video;

  public VideoEntry(int blogId) {
    super(blogId);
  }

  public void embedVideo(String video) {
   this.video="<video>"+video+"</video>";
  }

  public String getVideo() {
    return video;
  }

  @Override
  public boolean printEntry() {
    super.printEntry();
    System.out.println("Content: ");
    System.out.println(video);
    return true;
  }
}
