package com.endava.architecturedemo.screens.mvp;

import com.endava.architecturedemo.data.domain.User;
import com.endava.architecturedemo.data.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MvpPresenterTest {

  private MvpView view;
  private MvpModel model;
  private CompositeSubscription subscriptions;
  private UserRepository userRepository;
  private MvpPresenter presenter;

  @Before
  public void setUp() throws Exception {
    view = mock(MvpView.class);
    model = mock(MvpModel.class);
    subscriptions = new CompositeSubscription();
    userRepository = new UserRepository();

    presenter = new MvpPresenter(model, view, subscriptions);
  }

  @Test
  public void onCreate() throws Exception {
    when(view.mvcClicks()).thenReturn(Observable.never());
    when(view.mvpClicks()).thenReturn(Observable.never());
    when(view.viperClicks()).thenReturn(Observable.never());

    User user = userRepository.getUser();
    doNothing().when(model).storeUser(user);
    when(model.getNetworkUser(user.getName())).thenReturn(Observable.just(user));

    presenter.onCreate();

    verify(view).mvcClicks();
    verify(view).mvpClicks();
    verify(view).viperClicks();
    verify(model).getNetworkUser(user.getName());
    verify(model).storeUser(user);
  }

  @Test
  public void onDestroy() throws Exception {
    presenter.onDestroy();

    assertFalse(subscriptions.hasSubscriptions());
  }
}