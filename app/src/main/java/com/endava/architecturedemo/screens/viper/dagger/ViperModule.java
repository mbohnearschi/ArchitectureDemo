package com.endava.architecturedemo.screens.viper.dagger;

import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.data.repository.UserRepository;
import com.endava.architecturedemo.screens.viper.ViperActivity;
import com.endava.architecturedemo.screens.viper.ViperInteractor;
import com.endava.architecturedemo.screens.viper.ViperPresenter;
import com.endava.architecturedemo.screens.viper.ViperRouter;
import com.endava.architecturedemo.screens.viper.ViperView;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module
public class ViperModule {

  private final ViperActivity activity;

  public ViperModule(ViperActivity activity) {
    this.activity = activity;
  }

  @Provides
  @ViperScope
  public ViperView view() {
    return new ViperView(activity);
  }

  @Provides
  @ViperScope
  public ViperPresenter presenter(ViperInteractor interactor, ViperRouter router, ViperView view) {
    return new ViperPresenter(interactor, router, view, new CompositeSubscription());
  }

  @Provides
  @ViperScope
  public ViperInteractor interactor(UserRepository userRepository, NetworkApi networkApi) {
    return new ViperInteractor(activity, userRepository, networkApi);
  }

  @Provides
  @ViperScope
  public ViperRouter router() {
    return new ViperRouter(activity);
  }
}
