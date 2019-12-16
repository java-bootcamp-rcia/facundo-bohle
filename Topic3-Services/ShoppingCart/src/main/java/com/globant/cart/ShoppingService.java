package com.globant.cart;

import com.globant.user.User;
import java.util.ArrayList;
import java.util.List;

public class ShoppingService {
  private static List<ShoppingCart> cartList= new ArrayList<>();
  private static ShoppingCart currentCart;

  private ShoppingService(){}

  public static boolean createNewCart(User user) {
    //Generating cart Id
    int newCartId=1;

    for (ShoppingCart cart : cartList) {
      if (cart.getId()>=newCartId)
        newCartId=cart.getId()+1;
    }
    // Attach the cart to its user
    user.setCartId(newCartId);

    // Creating cart
    ShoppingCart newCart= new ShoppingCart(newCartId);
    cartList.add(newCart);

    return true;
  }

  public static List<ShoppingCart> getCartList() {
    return cartList;
  }

  public static String addItem(int cartId, String name, double quantity, double price, double discount ) {
    // Get Cart
    currentCart = getCart(cartId);
    if (currentCart ==null)
      return "Error - Cart with that ID does not exist.";

    // Generate new item ID
    int newItemId=1;
    List<Item> cartItems= currentCart.getItemsArrayList();
    for (Item item : cartItems) {
      if (item.getId()>=newItemId)
        newItemId= item.getId()+1;
    }

    // Check for errors
    if (name.length()>20)
      return "Error - Name too long";

    if (discount>100)
      return "Error - discount bigger than 100";

    if (price<0 || quantity<0 || discount <0)
      return "Error - Negative numbers not accepted";

    // Add new Item to cart
    currentCart.addItem(newItemId,name,quantity,price,discount);
    return "Successful Request - Item Was Added";
  }

  public static String deleteItem(int cartId, int itemId) {
    currentCart = getCart(cartId);
    if (currentCart ==null)
      return "Error - Cart Does Not Exist";

    currentCart.deleteItem(itemId);

    return "Successful Request - Item Deleted";
  }

  public static String updateItem(int cartId, int itemId, String field, double value){
    currentCart= getCart(cartId);
    if (currentCart==null)
      return "Error - Cart Does Not Exist";

    boolean isUpdated=  currentCart.updateItem(itemId,field,value);
    if (isUpdated)
      return "Successful Request - Item Updated";

    return "Wrong parameters - Try again";
  }

  public static String getAllItems(int cartId) {
    currentCart=getCart(cartId);
    if (currentCart==null)
      return "Error - Cart Does Not Exist";
    return currentCart.getAllItems();
  }

  public static String getItem(int cartId, int itemId) {
    try {
      currentCart = getCart(cartId);
      currentCart.getItem(itemId);
    } catch (Exception e) {
      return "Error - Item Or Cart Does not exist";
    }
    return  currentCart.getItem(itemId);
  }

  private static ShoppingCart getCart(int id) {
    for (ShoppingCart cart : cartList) {
      if (cart.getId()==id)
        return cart;
    }
    return null;
  }
}
