package com.endava.architecturedemo.screens.viper.dagger;

import com.endava.architecturedemo.app.dagger.AppComponent;
import com.endava.architecturedemo.screens.viper.ViperActivity;
import dagger.Component;

@ViperScope
@Component(modules = ViperModule.class, dependencies = AppComponent.class)
public interface ViperComponent {

  void inject(ViperActivity activity);
}
