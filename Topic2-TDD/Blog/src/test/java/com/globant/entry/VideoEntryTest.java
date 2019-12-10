package com.globant.entry;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class VideoEntryTest {

  @Spy
  VideoEntry entry= new VideoEntry(2);

  @Test
  public void canEmbedVideo() {

    String video="https://www.youtube.com/watch?v=b-Cr0EWwaTk";


    entry.embedVideo(video);
    verify(entry).embedVideo(video);

    assertTrue("Did not embed correctly",("<video>" + video + "</video>").equals(entry.getVideo()));
  }
}
