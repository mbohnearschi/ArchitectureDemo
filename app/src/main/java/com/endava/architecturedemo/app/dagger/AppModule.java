package com.endava.architecturedemo.app.dagger;

import android.content.Context;
import com.endava.architecturedemo.api.MockNetworkApi;
import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.data.repository.UserRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
  private final Context context;

  public AppModule(Context context) {
    this.context = context;
  }

  @Provides
  @AppScope
  public Context context() {
    return context;
  }

  @Provides
  @AppScope
  public UserRepository userRepository() {
    return new UserRepository();
  }

  @Provides
  @AppScope
  public NetworkApi networkApi() {
    return new MockNetworkApi();
  }
}
