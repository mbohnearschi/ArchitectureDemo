package com.endava.architecturedemo.screens.viper;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.endava.architecturedemo.R;
import com.jakewharton.rxbinding.view.RxView;
import rx.Observable;

public class ViperView {

  @BindView(R.id.mvc)
  View mvc;
  @BindView(R.id.mvp)
  View mvp;
  @BindView(R.id.viper)
  View viper;

  private View view;
  private ViperActivity activity;

  public ViperView(ViperActivity activity) {
    this.activity = activity;
    view = View.inflate(activity, R.layout.activity_content, null);
    ButterKnife.bind(this, view);
  }

  public View getView() {
    return this.view;
  }

  public Observable<Void> mvcClicks() {
    return RxView.clicks(mvc);
  }

  public Observable<Void> mvpClicks() {
    return RxView.clicks(mvp);
  }

  public Observable<Void> viperClicks() {
    return RxView.clicks(viper);
  }
}
