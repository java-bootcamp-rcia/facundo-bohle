package com.globant.cart;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

import com.globant.user.User;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

public class ShoppingServiceTest {

  private List<ShoppingCart> cartList= ShoppingService.getCartList();

  @Spy
  User spyUser= new User(1,2,23,null,"","","","","");

  @Before
  public void setUp() {
    ShoppingService.createNewCart(spyUser);
    ShoppingService.addItem(1, "Socks", 1.0,2.0,0.0);
  }

  @Test
  public void canAddItemsToCart() {

    assertFalse("Cart is empty!",cartList.isEmpty());
    assertEquals("Item was not added to cart", cartList.get(0).getItemsArrayList().get(0).getName(), "Socks");
  }

  @Test
  public void givenCartDoesNotExist_whenCallToAddItems_thenReturnError() {
    String result= ShoppingService.addItem(202,"Inexistent",2.0,2.0,1.0);

    assertEquals("Item was added to non-existent cart (?)","Error - Cart with that ID does not exist.", result);
  }

  @Test
  public void canDeleteItem() {
   String result= ShoppingService.deleteItem(1,1);

   assertTrue(ShoppingService.getCartList().get(0).getItemsArrayList().isEmpty());
   assertEquals("Was not deleted.",result,"Successful Request - Item Deleted");
  }

  @Test
  public void whenUpdatingWithWrongItemId_thenReturnErrorMessage() {
    String result= ShoppingService.updateItem(1, 123, "price",2.0);

    assertEquals(result,"Wrong parameters - Try again");
  }

  @Test
  public void whenGetAllItems_thenReturnJsonString() {
    String result=ShoppingService.getAllItems(1);

    assertEquals("Didn't return a Json String",result,
        "[{\"id\":1,\"name\":\"Socks\",\"quantity\":1.0,\"price\":2.0,\"discount\":0.0}]");
  }

  @Test
  public void whenGetItemById_thenReturnJsonString() {
    String result= ShoppingService.getItem(1,1);
    System.out.println(result);
    //assertEquals("Didn't return Json Item",result,);
  }

  @After
  public void tearDown() {
    ShoppingService.getCartList().clear();
  }
}
