package com.endava.architecturedemo.screens.mvp.dagger;

import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.data.repository.UserRepository;
import com.endava.architecturedemo.screens.mvp.MvpActivity;
import com.endava.architecturedemo.screens.mvp.MvpModel;
import com.endava.architecturedemo.screens.mvp.MvpPresenter;
import com.endava.architecturedemo.screens.mvp.MvpView;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module
public class MvpModule {

  private final MvpActivity activity;

  public MvpModule(MvpActivity activity) {
    this.activity = activity;
  }

  @Provides
  @MvpScope
  public MvpView view() {
    return new MvpView(activity);
  }

  @Provides
  @MvpScope
  public MvpPresenter presenter(MvpModel model, MvpView view) {
    return new MvpPresenter(model, view, new CompositeSubscription());
  }

  @Provides
  @MvpScope
  public MvpModel model(UserRepository userRepository, NetworkApi networkApi) {
    return new MvpModel(activity, userRepository, networkApi);
  }
}
