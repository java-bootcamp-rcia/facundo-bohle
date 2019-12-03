package com.globant.builder.connection;

import java.util.Scanner;

public abstract class ConnectionItem {

  // Connection item field
  protected String value="";

  // Retrieves info
  public String getValue() {
    if (this.value.equals("")) {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter a valid"+this.getClass().getName());
      this.value = input.nextLine();
    }
    return this.value;
  }
}
