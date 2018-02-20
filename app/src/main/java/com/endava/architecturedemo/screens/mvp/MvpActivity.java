package com.endava.architecturedemo.screens.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.endava.architecturedemo.app.MainApplication;
import com.endava.architecturedemo.screens.mvp.dagger.DaggerMvpComponent;
import com.endava.architecturedemo.screens.mvp.dagger.MvpModule;
import javax.inject.Inject;

public class MvpActivity extends AppCompatActivity {

  @Inject
  MvpView view;
  @Inject
  MvpPresenter presenter;

  public static void start(Context context) {
    Intent intent = new Intent(context, MvpActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DaggerMvpComponent.builder()
      .appComponent(MainApplication.getAppComponent())
      .mvpModule(new MvpModule(this))
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