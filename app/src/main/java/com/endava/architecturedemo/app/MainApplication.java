package com.endava.architecturedemo.app;

import android.app.Application;
import com.endava.architecturedemo.app.dagger.AppComponent;
import com.endava.architecturedemo.app.dagger.AppModule;
import com.endava.architecturedemo.app.dagger.DaggerAppComponent;

public class MainApplication extends Application {

  private static AppComponent appComponent;

  public static AppComponent getAppComponent() {
    return appComponent;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    initComponent();
  }

  protected void initComponent() {
    appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    appComponent.inject(this);
  }
}
