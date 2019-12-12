/**
*	Purchase is an object from an users' Software which connects with the Shopping Cart API 
*	Self explanatory items/implementation are abbreviated with "//..."
/


public class Purchase {
  private cartId=0;

  // Sets up the connection
  public HTTP query(String url, String requestType, String operationId, String...params) {
	//
    return response;
  } 

  public boolean newCart() {
	this.cartId=query("http://mydb.com/cart","POST","newCart"); // returns the id of the newly created cart
  }
   
  //add item to the cart 
  public boolean addItem(String name, Quantity quantity) { 
    try {
	  query("http://mydb.com/cart","POST","addItem",name,quantity);
	} catch (Exception e) {
	  e.printStackTrace();
	  return false;
	}
	return true;
  }

  public boolean removeItem() { // ... }

  public void showCartItems() {}

  //cost of a single item
  public boolean getCost(String name) {
   int cost= query(url, "GET", "itemCost",itemId);
   //....
   return cost;
  }

  //cost of the cart
  public boolean getCost() {// ...  }

  public boolean confirmPayment() {// ... }

  public boolean buy() {
  //...
  try{
    confirmPayment();
  } catch(Exception e) {
	//...
    return false;
  }
  cartId=0;
  return true
  }
}

// Should null or destroy the purchase after It's been successfully conducted (buy returns true)