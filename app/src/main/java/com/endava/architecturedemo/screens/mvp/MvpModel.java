package com.endava.architecturedemo.screens.mvp;

import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.data.domain.User;
import com.endava.architecturedemo.data.repository.UserRepository;
import com.endava.architecturedemo.screens.mvc.MvcActivity;
import com.endava.architecturedemo.screens.viper.ViperActivity;
import rx.Observable;

public class MvpModel {

  private final MvpActivity activity;
  private final UserRepository userRepository;
  private final NetworkApi networkApi;

  public MvpModel(MvpActivity activity, UserRepository userRepository, NetworkApi networkApi) {
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

  public void showMvcScreen() {
    MvcActivity.start(activity);
  }

  public void showMvpScreen() {
    MvpActivity.start(activity);
  }

  public void showViperScreen() {
    ViperActivity.start(activity);
  }
}
