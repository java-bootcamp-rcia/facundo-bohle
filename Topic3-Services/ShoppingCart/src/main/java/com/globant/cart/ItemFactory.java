/**
 * ItemFactory represents a Singleton entity which is used by {@link com.globant.cart.ShoppingCart} instances
 * to produce {@link com.globant.cart.Item} type objects.
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant.cart;

public class ItemFactory {

  private static ItemFactory instance= new ItemFactory();


  private ItemFactory() {}

  public static ItemFactory getInstance() {
    return instance;
  }


  /**
   * @return {@link Item} type object
   * @param id Item's id
   * @param name Item's name
   * @param doubles an array containing double type numbers in the next order: Quantity, price, discount
   * @since 1.0
   */
  public Item newItem(int id, String name, double...doubles) {
    Item addedItem= new Item(id,name,doubles);

    return addedItem;
  }

}
