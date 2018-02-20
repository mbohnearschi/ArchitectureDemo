package com.endava.architecturedemo.api;

import com.endava.architecturedemo.data.domain.User;
import rx.Observable;

public interface NetworkApi {
  User getUser(String username);

  Observable<User> rxGetUser(String username);
}