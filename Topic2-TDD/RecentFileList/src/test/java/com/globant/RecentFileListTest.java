package com.globant;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecentFileListTest{

  private RecentFileList recent;
  private List list;

  @Before
  public void setUp() {
    System.out.println("Running: setUp");
    recent= new RecentFileList();
    list= recent.getList();
  }

  @Test
  public void whenCreated_thenIsEmpty() {
    System.out.println("Running: whenCreate_thenIsEmpty");
    assertTrue("List was not created empty",recent.getList().isEmpty());
  }

  @Test
  public void whenOpenedTwice_thenItsBroughtToFront(){
    System.out.println("Running: whenOpenedTwice_thenItsBroughtToFront");

    String file1="~/test.txt";
    String file2="~/anothertest.txt";

    recent.open(file1,file2,file1);

   assertThat("File was not brought to front",file1,is(list.get(list.size()-1)));
   assertThat("File appears more than once in the Recent list",Collections.frequency(list,file1),is(1));

  }

 @Test
 public void when16thItemAdded_thenOldestIsDeleted() {
   System.out.println("Running: when16thItemAdded_thenOldestIsDeleted");

   for(int i=0; i<=15 ; i++)
      recent.open("~/file"+Integer.toString(i)+".txt");


    assertThat("List overreached 15th item",list.size(),is(15));
    assertThat("Most recent file was not added","~/file15.txt",is(list.get(14)));
    assertThat("Oldest was not deleted","~/file1.txt", is(list.get(0)));

 }

 @Test
 public void canPrintListFromNewestToOldest() {

    recent.open("file1","file2");
    assertThat("file2",is(recent.printList()));
 }

  @After
  public void tearDown() {
    System.out.println("Running: tearDown");
    recent=null;
  }


}