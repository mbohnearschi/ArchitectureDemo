package com.endava.architecturedemo.screens.mvp;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MvpPresenter {

  private final MvpModel model;
  private final MvpView view;
  private final CompositeSubscription subscriptions;

  public MvpPresenter(MvpModel model, MvpView view, CompositeSubscription subscriptions) {
    this.model = model;
    this.view = view;
    this.subscriptions = subscriptions;
  }

  public void onCreate() {
    subscriptions.add(mvcClicksSubscription());
    subscriptions.add(mvpClicksSubscription());
    subscriptions.add(viperCLicksSubscription());
    subscriptions.add(getUserSubscription());
  }

  public void onDestroy() {
    subscriptions.clear();
  }

  private Subscription mvcClicksSubscription() {
    return view.mvcClicks().subscribe(aVoid -> model.showMvcScreen());
  }

  private Subscription mvpClicksSubscription() {
    return view.mvpClicks().subscribe(aVoid -> model.showMvpScreen());
  }

  private Subscription viperCLicksSubscription() {
    return view.viperClicks().subscribe(aVoid -> model.showViperScreen());
  }

  private Subscription getUserSubscription() {
    return model.getNetworkUser("George").subscribe(model::storeUser);
  }
}
