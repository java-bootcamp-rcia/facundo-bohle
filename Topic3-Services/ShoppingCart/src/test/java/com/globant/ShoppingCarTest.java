package com.globant;

import static junit.framework.TestCase.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingCarTest {

  @Spy
  ShoppingCart spyCart = new ShoppingCart();

  @Test
  public void givenCartIsEmpty_whenCallGetItems_thenItDoesNotFail() {
    String jsonResponse = "";

    try {
      jsonResponse = spyCart.getAllItems();
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }

    verify(spyCart).getAllItems();
    assertTrue("Is not a JSON Type", jsonResponse instanceof String);
  }

  @Test
  public void whenCallGetWithWrongId_thenReturnErrorMessage() {
    assertEquals("Doesn't treat wrong ID Input","Error - Item with that id doesn't exist", spyCart.getItem(120));
  }

  @Mock
  Item mockItem;

  @Test
  public void whenAddNewObjectItem_thenReturnTrue() {
     when(mockItem.getId()).thenReturn(1);
     spyCart.addItem(mockItem);

    verify(spyCart).addItem(mockItem);
    assertFalse("Item was not added",spyCart.getItemsArrayList().isEmpty());
    assertEquals("Didn't add properly",1, mockItem.getId());
  }

  @Test
  public void whenAddNewItemByParameters_thenReturnTrue() {
    boolean added = spyCart.addItem(2,"Sneakers",1.0,400.00,2.7);

    verify(spyCart).addItem(2,"Sneakers",1.0,400.00,2.7);
    assertTrue("Was not added",added);
    assertThat("Was not added properly",spyCart.getItemsArrayList().get(0).getId(), is(2));
  }



  @Test
  public void givenItemInCart_whenSameItemAdded_thenReturnFalse() {
    boolean addedItem = spyCart.addItem(mockItem);
    when(mockItem.getId()).thenReturn(2);
    boolean addSameItem= spyCart.addItem(2,"OtherItemWithSameId", 2.0,200.0,2.8);


    assertTrue("Item was not added",addedItem);
    assertFalse("Added Two Items with Same Id",addSameItem);
  }

  @Test
  public void canRemoveItem() {
    spyCart.addItem(mockItem);
    when(mockItem.getId()).thenReturn(2);
    boolean isDeleted=spyCart.deleteItem(2);


    verify(spyCart).addItem(mockItem);
    verify(spyCart).deleteItem(2);

    assertTrue(isDeleted);
    assertTrue(spyCart.getItemsArrayList().isEmpty());
  }

  @Test
  public void givenIdDoesNotExist_whenCallForRemoval_thenReturnFalse() {

    boolean isDeleted= spyCart.deleteItem(203);

    assertFalse(isDeleted);
  }

  @Spy
  Item spyItem = new Item(172, "Socks", 2.0,10.0,1.2);

  @Test
  public void canUpdateItemInCart() {
    spyCart.addItem(spyItem);
    spyCart.updateItem(172,"quantity",3.0);

    boolean isUpdated = spyCart.updateItem(172,"wrongInput",2.0);
    boolean worksForWrongId= spyCart.updateItem(120,"quantity",4.0);

    verify(spyCart).addItem(spyItem);
    verify(spyCart).updateItem(172,"quantity",3.0);
    assertEquals("Did not update",spyCart.getItemsArrayList().get(0).getQuantity(),3.0);
    assertFalse("Updated wrong Field",isUpdated);
    assertFalse("Does not treat wrong Id's",worksForWrongId);
  }

  @Test
  public void canCalculateFinalAmount() {
    spyCart.addItem(spyItem);
    double finalAmount=spyCart.calculateAmount();


    verify(spyCart).calculateAmount();

    assertEquals("Didn't calculate the correct amount",finalAmount,19.76);
  }

}