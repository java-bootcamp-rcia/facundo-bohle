package com.globant.blog;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.globant.entry.Entry;
import org.junit.*;


public class BlogTest {

  private Blog blog1;
  private Blog blog2;

  @Before
  public void setUp() {
    blog1= new Blog("Blog1");
    blog2= new Blog("Blog2");
  }


  //Blog related tests

  @Test
  public void whenTwoBlogsAreCreated_thenTheyHaveDifferentId() {
    assertThat(blog1.getId(),is(not(blog2.getId())));
  }

  @Test
  public void whenTwoBlogsAreCreated_thenTheyUseSameEntryFactory() {
    assertEquals(blog1.getFactory(),blog2.getFactory());
  }


  // Entry related tests
  @Test
  public void whenUserInputsEntry_thenEntryIsCreatedAndSaved() {
    Entry entry=blog1.add("Text","My Newest Video","");
    Entry entry2=blog1.add("Video","My newest Text","");


    assertNotNull(entry);
    assertNotNull(entry2);
  }






  @After
  public void tearDown() {
    blog1=null;
    blog2=null;
  }

}
