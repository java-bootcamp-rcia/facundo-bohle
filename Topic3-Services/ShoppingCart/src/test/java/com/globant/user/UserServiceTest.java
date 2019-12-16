package com.globant.user;

import static junit.framework.TestCase.*;

import com.globant.cart.ShoppingService;
import java.util.List;
import org.junit.*;

public class UserServiceTest {
  private List<User> usersList=UserService.getUsersArrayList();

  @Test
  public void whenUserIsCreated_thenReturnTrue_andAssignCart() throws Exception {

    boolean result=UserService.newUser(23,"Facundo","Bohle","bohledevs","mypass","facubohle2@gmail.com");

    assertTrue("User was not created",result);
    assertEquals("User was wrongly created",23, usersList.get(0).getAge());
    assertEquals("Cart was not assigned to new user.", usersList.get(0).getCartId(),1);

  }

  @Test
  public void whenGetUsersListCalled_thenReturnJsonString() {
    String json=UserService.getUsersList();
    assertNotNull("Output string was null!",json);
    assertEquals("Was not properly converted to Json",json,"[]");
  }


  @Test
  public void whenGetUserInfoByIdCalled_thenReturnJsonString() throws Exception {
    createUser();
    assertNotNull(UserService.getUserInfo(1));
  }


  @Test
  public void canUpdateUserIgnoreCase() throws Exception {
    createUser();
    User user= usersList.get(0);
    UserService.updateUser(1,"username","bohleSoft");
    UserService.updateUser(1,"pAsSwoRd","bohle95");
    UserService.updateUser(1,"eMAil","bohle@yahoo.com");


    assertEquals("User was not updated",user.getUserName(), "bohleSoft");
    assertEquals("Password was not updated",user.getPassword(),"bohle95");
    assertEquals("Email was not updated",user.getEmail(),"bohle@yahoo.com");
  }

  @Test
  public void canDeleteUserById() throws Exception {
    createUser();
    UserService.deleteUser(1);


    assertTrue("User was not deleted",usersList.isEmpty());
  }


  @After
  public void tearDown() {
    usersList.clear();
    ShoppingService.getCartList().clear();
  }


  private void createUser() throws Exception {
    UserService.newUser(23,"Facundo","Bohle","bohledevs","mypass","facubohle2@gmail.com");
  }

}
