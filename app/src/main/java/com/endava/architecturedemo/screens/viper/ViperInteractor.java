package com.endava.architecturedemo.screens.viper;

import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.data.domain.User;
import com.endava.architecturedemo.data.repository.UserRepository;
import rx.Observable;

public class ViperInteractor {

  private final ViperActivity activity;
  private final UserRepository userRepository;
  private final NetworkApi networkApi;

  public ViperInteractor(ViperActivity activity, UserRepository userRepository, NetworkApi networkApi) {
    this.activity = activity;
    this.userRepository = userRepository;
    this.networkApi = networkApi;
  }

  public Observable<User> getNetworkUser(String name) {
    return networkApi.rxGetUser(name);
  }

  public void storeUser(User user) {
    userRepository.storeUser(user);
  }
}
