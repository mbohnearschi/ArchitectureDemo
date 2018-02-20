package com.endava.architecturedemo.app.dagger;

import android.content.Context;
import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.app.MainApplication;
import com.endava.architecturedemo.data.repository.UserRepository;
import dagger.Component;

@AppScope
@Component(modules = { AppModule.class })
public interface AppComponent {

  Context context();

  UserRepository userRepository();

  NetworkApi networkApi();

  void inject(MainApplication mainApp);
}
