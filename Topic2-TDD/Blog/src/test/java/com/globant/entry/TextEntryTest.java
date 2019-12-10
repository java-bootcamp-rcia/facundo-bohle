package com.globant.entry;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class TextEntryTest {

  @Spy
  TextEntry entry= new TextEntry(2);

  @Test
  public void whenSpecialTextIsAdded_thenItsWrappedWithHTML(){
    entry.writeText("");
    entry.addSubtitle("My Subtitle");
    entry.addLink("Google","www.google.com");

    verify(entry).writeText("");
    verify(entry).addSubtitle("My Subtitle");
    verify(entry).addLink("Google","www.google.com");

    assertEquals("<h1>My Subtitle</h1>\n<a href='www.google.com'>Google</a>", entry.getText());
  }



  @Test
  public void canPrintEntryDetails() {
    assertTrue(entry.printEntry());
  }




}
