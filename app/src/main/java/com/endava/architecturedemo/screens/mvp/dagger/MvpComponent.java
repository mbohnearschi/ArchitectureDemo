package com.endava.architecturedemo.screens.mvp.dagger;

import com.endava.architecturedemo.app.dagger.AppComponent;
import com.endava.architecturedemo.screens.mvp.MvpActivity;
import dagger.Component;

@MvpScope
@Component(modules = MvpModule.class, dependencies = AppComponent.class)
public interface MvpComponent {

  void inject(MvpActivity activity);
}
