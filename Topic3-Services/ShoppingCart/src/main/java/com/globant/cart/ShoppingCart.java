/**
 * Shopping Cart is an entity which represents a real-life shopping cart.
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.cart;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  private int id;
  private List<Item> items= new ArrayList<>();


  public ShoppingCart(int id) {
    this.id=id;
  }

  public String getAllItems() {
      return convertToJson(items);
  }

  public List<Item> getItemsArrayList() {
    return items;
  }

  public String getItem(int id) {
    Item foundItem=null;

    for (Item item: items) {
      if (item.getId() == id)
        foundItem = item;
    }

    if (foundItem==null)
      return "Error - Item with that id doesn't exist";

    return convertToJson(foundItem);
  }


  /**
   * Adds item when user introduces a {@link Item} type object
   * @return true if added, false if an error occurred
   * @param item a {@link Item} type object
   * @since 1.0
   */
  public boolean addItem(Item item) {
    if (isDuplicated(item.getId())) {
      return false;
    } else {
      items.add(item);
      return true;
    }
  }

  /**
   * Adds item when user introduces new item values parameter by parameter
   * @return  true if added, cfalse if an error occurred
   * @param id Item's id
   * @param name Item's name
   * @param doubles an array containing double type numbers in the next order: Quantity, price, discount
   * @since 1.0
   */
  public boolean addItem(int id, String name, double...doubles) {

    if (isDuplicated(id))
      return false;

    ItemFactory factory = ItemFactory.getInstance();
    items.add(factory.newItem(id,name,doubles));
    return true;
  }


  /**
   * Deletes an item from the cart
   * @return true if deleted, false if an  error occurred
   * @param id Item's id
   * @since 1.0
   */
  public boolean deleteItem(int id) {
    int deleted = 0;

    if (isDuplicated(id)) {
      for (Item i : items) {
        if (i.getId() == id)
          deleted = items.indexOf(i);
      }
      items.remove(deleted);
      return true;
    }
      return false;
  }

  /**
   * @return true if updated, false if an error occurred
   * @param id Item's id
   * @param field Item's field to be updated (quantity, price or discount)
   * @param value Value to be updated
   * @since 1.0
   */
  public boolean updateItem(int id,String field, double value) {
    Item item = null;

    if (!isDuplicated(id))
      return false;

    try {
      for (Item i : items) {
        if (i.getId() == id)
          item = i;
      }

      if ("quantity".equalsIgnoreCase(field)) {
        item.setQuantity(value);
      } else if ("price".equalsIgnoreCase(field)) {
        item.setPrice(value);
      } else if ("discount".equalsIgnoreCase(field)) {
        item.setDiscount(value);
      }  else {
        return false;
      }
      return true;
    } catch (Exception e) {
      e.getMessage();
      return false;
    }
  }

  /**
   * Calculates final cart's amount in US Dollars, discounts applied
   * @return a double type final amount
   * @since 1.0
   */
  public double calculateAmount() {
    double finalAmount=0;
    double undiscountedPrice=0;
    for (Item i : items){
      undiscountedPrice= (i.getPrice()*i.getQuantity());
      finalAmount+= (undiscountedPrice - undiscountedPrice*(i.getDiscount() / 100));
    }
    return finalAmount;
  }

  private String convertToJson(Object obj) {
    Gson gson= new Gson();
    return gson.toJson(obj);
  }

  private boolean isDuplicated(int id ) {
    for (Item item: items) {
      if (item.getId() == id)
        return true;
     }
    return false;
  }

  public int getId() {
    return id;
  }
}
