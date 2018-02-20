package com.endava.architecturedemo.screens.viper;

import com.endava.architecturedemo.screens.mvc.MvcActivity;
import com.endava.architecturedemo.screens.mvp.MvpActivity;

public class ViperRouter {

  private final ViperActivity activity;

  public ViperRouter(ViperActivity activity) {
    this.activity = activity;
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