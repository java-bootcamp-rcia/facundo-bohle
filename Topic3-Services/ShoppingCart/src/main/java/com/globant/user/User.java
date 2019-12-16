/**
 * User represents a real-life customer of a commercial premise, brought to a web platform
 *
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.user;

import java.time.LocalDateTime;

public class User {
  private int id;
  private int cartId;
  private int age;
  private LocalDateTime dateOfCreation;
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String email;

  public User(int id, int cartId, int age, LocalDateTime dateOfCreation, String...params) {
        this.id= id;
        this.cartId=cartId;
        this.age=age;
        this.dateOfCreation= dateOfCreation;
        firstName= params[0];
        lastName=params[1];
        userName=params[2];
        password=params[3];
        email=params[4];
  }

  public int getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getCartId() {
    return cartId;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }
}
