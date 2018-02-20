package com.endava.architecturedemo.screens.mvp;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.endava.architecturedemo.R;
import com.jakewharton.rxbinding.view.RxView;
import rx.Observable;

public class MvpView {

  @BindView(R.id.mvc)
  View mvc;
  @BindView(R.id.mvp)
  View mvp;
  @BindView(R.id.viper)
  View viper;

  private View view;
  private MvpActivity activity;

  public MvpView(MvpActivity activity) {
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