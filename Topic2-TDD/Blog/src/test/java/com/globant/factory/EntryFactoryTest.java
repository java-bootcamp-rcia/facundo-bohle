package com.globant.factory;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


import com.globant.database.DBAccessor;
import com.globant.entry.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class EntryFactoryTest {

  private EntryFactory factory= EntryFactory.getInstance();

  @Test
  public void canOnlyExistOneFactory() {
    EntryFactory factory2= EntryFactory.getInstance();
    assertEquals("Two factories exist",factory,factory2);
  }


  // do not want to access a real DB
  @Mock
  DBAccessor accessor = new DBAccessor();

  @Spy
  private Entry entry1= factory.newEntry(1,accessor,"Video","My Newest video","Youtube.com/KASD1");
  private Entry entry2= factory.newEntry(2,accessor,"Text","My Daily Routine","...");

  @Test
   public void canCreateVideoEntry() {
    assertTrue(entry1 instanceof VideoEntry);
  }

  @Test
  public void canCreateTextEntry() {
    assertTrue(entry2 instanceof TextEntry);
  }

  @Test
  public void whenTwoEntriesAreCreated_thenTheyHaveDifferentIds() {
    assertThat(entry1.getId(),is(not(entry2.getId())));
  }

  // do not want to save a real entry, only test the method
  @Mock
  Entry mockEntry;
  @Spy
  EntryFactory spyFactory = EntryFactory.getInstance();

  @Test
  public void whenSaveMethodCalled_thenFactoryCarriesTheSave() {

    doReturn(true).when(accessor).executeDataRead(mockEntry);

    boolean saved= spyFactory.save(mockEntry,accessor);

    verify(spyFactory).save(mockEntry,accessor);

    assertTrue("Factory didn't carry the save",saved);
  }



  @After
  public void tearDown() {
    factory=null;
  }



}
