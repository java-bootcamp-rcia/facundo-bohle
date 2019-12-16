/**
 * Static class UserService encapsulates all the activities related to the management of {@link com.globant.user.User} instances,
 * It's the platform which the API user interacts with.
 * @author bohledevs
 * @version 1.0
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.user;

import com.globant.cart.ShoppingService;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserService {

  private static List<User> users= new ArrayList<>();

  private UserService() {}


  /**
   *
   * @throws Exception when wrong data has been input
   * @return true or false, depending on If the {@link com.globant.user.User} instance was created or not
   * @since 1.0
   */
  public static boolean newUser(int age, String firstName, String lastName, String userName, String password, String email) {

   // Error checking
    try {
      if (age == 0 || firstName == null || lastName == null || userName == null || password == null
          || email == null)
        throw new Exception("Entries can not be empty!");
      if (age < 0 || age > 110)
        throw new Exception("Age is incorrect.");
      if (firstName.length() > 20 || lastName.length() > 20 || userName.length() > 20
          || password.length() > 20)
        throw new Exception("Input too long.");
      if (!email.contains("@"))
        throw new Exception("Wrong email input.");
    } catch (Exception e) {
      e.getMessage();
      return false;
    }

    //Generating ID
    int newUserId= 1;
    for (User user : users) {
      if (user.getId()>=newUserId)
        newUserId=user.getId()+1;
    }

    //Generating Date of Creation
    LocalDateTime newUserDate= LocalDateTime.now();


    //Creating user
    User newUser= new User(newUserId, -1, age, newUserDate, firstName, lastName, userName, password, email);

    // Creating new cart for the user
    ShoppingService.createNewCart(newUser);

    // Adding the user to list
    users.add(newUser);

    return true;
  }

  /**
   * Responds to a request for an user list as ArrayList
   * @return a collection of {@link com.globant.user.User} objects as a {@link java.util.ArrayList} (To be used by application logic only)
   * @since 1.0
   */
  public static List<User> getUsersArrayList() {
    return users;
  }

  /**
   * Responds to a request for an user list as JSon
   * @return a Json string representing a collection of {@link com.globant.user.User} type objects
   * @since 1.0
   */
  public static String getUsersList() {
    return convertToJson(users);
  }

  /**
   * Responds to a request for an individual User's accessible information
   * @return a single {@link com.globant.user.User} type object as Json string
   * @since 1.0
   */
  public static String getUserInfo(int id) {
    User requested = getUser(id);

    if (requested==null)
      return "Error - User Does Not Exist";

    return convertToJson(requested);

  }

  /**
   * Updates permitted {@link com.globant.user.User} instace fields (one at a time)
   * @return true or false, depending on if the Update could be carried on
   * @param field a changeable {@link com.globant.user.User} instance field (username/password/email)
   * @param value a {@link java.lang.String} containing the value of said field
   * @since 1.0
   */
  public static boolean updateUser(int id, String field, String value) {
    if (isInList(id)) {
      User user = getUser(id);
      switch(field.toUpperCase()) {
        case "USERNAME":
          user.setUserName(value);
          break;
        case "PASSWORD":
          user.setPassword(value);
          break;
        case "EMAIL":
          user.setEmail(value);
          break;
        default:
          return false;
      }
      return true;
    }
    return false;
  }

  /**
   * @return true or false, depending on if the deletion was carried on
   * @since 1.0
   */
  public static boolean deleteUser(int id) {
    if (!isInList(id))
      return false;
    User user= getUser(id);
    int index= getUsersArrayList().indexOf(user);
    getUsersArrayList().remove(index);
    return true;
  }

  private static String convertToJson(Object obj) {
    Gson gson= new Gson();
    return gson.toJson(obj);
  }

  private static boolean isInList(int id) {
    for (User user: users) {
      if (user.getId()==id)
        return true;
    }
    return false;
  }

  private static User getUser(int id) {
    for (User user: users) {
      if (user.getId()==id)
        return user;
    }
    return null;
  }
}
