package com.globant.blog;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

import com.globant.entry.Entry;
import com.globant.entry.TextEntry;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class RecentEntryListTest {


  @Spy
  RecentEntryList list = new RecentEntryList();

  @Mock
  TextEntry entry1= new TextEntry(1);
  TextEntry entry2= new TextEntry(1);

  @Test
  public void whenMultipleEntriesAreAdded_thenLatestShownFirst() {
    list.add(entry1);
    list.add(entry2);

    verify(list).add(entry1);
    verify(list).add(entry2);

    assertEquals("Last entry wasn't shown first",list.printList(),entry2);
  }




  @Spy
  RecentEntryList spyRecent= new RecentEntryList();
  List<Entry> spyList = new ArrayList<>();

  @Test
  public void whenEleventhEntryAdded_thenRemoveOldest() {

    for (int i = 0 ; i<10 ; i++) {
      spyList.add(new TextEntry(2));
    }


    spyRecent.setList(spyList);
    Entry oldest=spyList.get(0);
    spyRecent.add(new TextEntry(1));



    assertTrue("List holds more than 10 entries", spyRecent.getList().size()<=10);
    assertThat("Oldest entry was not removed", spyRecent.getList().get(0), is(not(oldest)));
  }
}
