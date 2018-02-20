package com.endava.architecturedemo.app.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.CLASS)
@interface AppScope {
}