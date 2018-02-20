package com.endava.architecturedemo.screens.viper;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class ViperPresenter {

  private final ViperInteractor interactor;
  private final ViperRouter router;
  private final ViperView view;
  private final CompositeSubscription subscriptions;

  public ViperPresenter(ViperInteractor interactor, ViperRouter router, ViperView view,
    CompositeSubscription subscriptions) {
    this.interactor = interactor;
    this.router = router;
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
    return view.mvcClicks().subscribe(aVoid -> router.showMvcScreen());
  }

  private Subscription mvpClicksSubscription() {
    return view.mvpClicks().subscribe(aVoid -> router.showMvpScreen());
  }

  private Subscription viperCLicksSubscription() {
    return view.viperClicks().subscribe(aVoid -> router.showViperScreen());
  }

  private Subscription getUserSubscription() {
    return interactor.getNetworkUser("George").subscribe(interactor::storeUser);
  }
}
