package com.globant.builder.connection;

import java.util.Scanner;

public class Password extends ConnectionItem {
  @Override
  public String getValue() {
    if (this.value.equals("")) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a valid Password:");
      this.value = input.nextLine();
    }
    return this.value;
  }
}
