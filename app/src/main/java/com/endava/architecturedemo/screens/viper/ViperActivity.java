package com.endava.architecturedemo.screens.viper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.endava.architecturedemo.app.MainApplication;
import com.endava.architecturedemo.screens.viper.dagger.DaggerViperComponent;
import com.endava.architecturedemo.screens.viper.dagger.ViperModule;
import javax.inject.Inject;

public class ViperActivity extends AppCompatActivity {

  @Inject
  ViperView view;
  @Inject
  ViperPresenter presenter;

  public static void start(Context context) {
    Intent intent = new Intent(context, ViperActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DaggerViperComponent.builder()
      .appComponent(MainApplication.getAppComponent())
      .viperModule(new ViperModule(this))
      .build()
      .inject(this);

    setContentView(view.getView());
    presenter.onCreate();
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }
}