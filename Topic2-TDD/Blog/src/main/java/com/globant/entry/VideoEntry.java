/**
 * VideoEntry is a specialization of {@link com.globant.entry.Entry}
 * and provides behavior for the management of Video type inputs
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.entry;

public class VideoEntry extends Entry{

  private String video;

  public VideoEntry(int blogId) {
    super(blogId);
  }

  /**
   * Adds HTML tags to indicate the Entry that the input is a video link
   * @return void
   * @param video video link
   * @since 1.0
   */
  public void embedVideo(String video) {
   this.video="<video>"+video+"</video>";
  }

  public String getVideo() {
    return video;
  }

  /**
   * Specialization of method {@link com.globant.entry.Entry}.printEntry() but adds the video
   * content at the end.
   * @return true, after the listing had been printed
   * @since 1.0
   */
  @Override
  public boolean printEntry() {
    super.printEntry();
    System.out.println("Content: ");
    System.out.println(video);
    return true;
  }
}
