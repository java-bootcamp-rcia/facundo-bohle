/**
 * Static class ShoppingService establishes a set of available shopping options and represents the interface which the
 * API user interacts with. It encapsulates all the activities related to a {@link com.globant.cart.ShoppingCart}
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.cart;

import com.globant.user.User;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ShoppingService {
  private static List<ShoppingCart> cartList= new ArrayList<>();
  private static ShoppingCart currentCart;

  private ShoppingService(){}

  /**
   * Method used by {@link com.globant.user.UserService} to assign a new cart to each new user.
   * @return a {@link java.lang.String} message regarding either error or success
   * @param user a {@link com.globant.user.User} type object to which the cart will be added
   * @since 1.0
   */
  public static String createNewCart(User user) {
    if(user==null)
      return "Error - User Does Not Exist";

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

    return "Successful Request - Cart Added";
  }

  /**
   * Gets the existing carts as ArrayList (Designed for application logic - Not for users
   * @return a {@link java.util.ArrayList} type object which contains a collection of {@link com.globant.cart.ShoppingCart} instances
   * @since 1.0
   */
  public static List<ShoppingCart> getCartArrayList() {
    return cartList;
  }

  /**
   * Gets the existing carts as a Json String, per user request
   * @return a Json {@link java.lang.String} type object
   * @since 1.0
   */
  public static String getCartList() {
    Gson gson= new Gson();
    return gson.toJson(cartList);
  }

  /**
   * @return a {@link java.lang.String} type object, containing either an Error or Success message
   * @since 1.0
   */
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

  /**
   * @return a {@link java.lang.String} type object, containing either an Error or Success message
   * @since 1.0
   */
  public static String deleteItem(int cartId, int itemId) {
    currentCart = getCart(cartId);
    if (currentCart ==null)
      return "Error - Cart Does Not Exist";

    currentCart.deleteItem(itemId);

    return "Successful Request - Item Deleted";
  }

  /**
   * @return a {@link java.lang.String} type object, containing either an Error or Success message
   * @param field a changeable {@link com.globant.cart.Item} instance field (quantity/price/discount)
   * @param value the new {@link java.lang.Double} value for said field
   * @since 1.0
   */
  public static String updateItem(int cartId, int itemId, String field, double value){
    currentCart= getCart(cartId);
    if (currentCart==null)
      return "Error - Cart Does Not Exist";

    boolean isUpdated=  currentCart.updateItem(itemId,field,value);
    if (isUpdated)
      return "Successful Request - Item Updated";

    return "Wrong parameters - Try again";
  }

  /**
   *
   * @return A collection of {@link com.globant.cart.Item} objects in Json format
   * @since 1.0
   */
  public static String getAllItems(int cartId) {
    currentCart=getCart(cartId);
    if (currentCart==null)
      return "Error - Cart Does Not Exist";
    return currentCart.getAllItems();
  }

  /**
   * @return Either an error message or an {@link com.globant.cart.Item} object converted to Json String
   * @since 1.0
   */
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
