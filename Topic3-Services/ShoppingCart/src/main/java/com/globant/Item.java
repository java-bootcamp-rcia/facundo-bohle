/**
 * Item represents a real life item which can be purchased from a commercial entity.
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */

package com.globant;

public class Item {
  private int id;
  private String name;
  private double quantity;
  private double price;
  private double discount;



  public Item(int id, String name, double...doubles) {
      this.id= id;
      this.name=name;
      quantity= doubles[0];
      price= doubles[1];
      discount=doubles[2];
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }
}
