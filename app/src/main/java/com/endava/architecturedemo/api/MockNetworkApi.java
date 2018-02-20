package com.endava.architecturedemo.api;

import com.endava.architecturedemo.data.domain.User;
import com.endava.architecturedemo.data.repository.UserRepository;
import rx.Observable;

public class MockNetworkApi implements NetworkApi {

  private UserRepository userRepository;

  public MockNetworkApi() {
    userRepository = new UserRepository();
  }

  @Override
  public User getUser(String username) {
    return userRepository.getUser();
  }

  @Override
  public Observable<User> rxGetUser(String username) {
    return Observable.just(getUser(username));
  }
}