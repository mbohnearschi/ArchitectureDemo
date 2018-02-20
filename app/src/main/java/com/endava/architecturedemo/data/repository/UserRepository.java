package com.endava.architecturedemo.data.repository;

import com.endava.architecturedemo.data.domain.User;

public class UserRepository {

  public UserRepository() {
  }

  public void storeUser(User user) {

  }

  public User getUser() {
    User user = new User();
    user.setName("George");
    user.setEmail("george.shaft@gmail.com");
    return user;
  }
}
