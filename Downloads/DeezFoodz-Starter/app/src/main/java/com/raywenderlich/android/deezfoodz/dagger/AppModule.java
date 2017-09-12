package com.raywenderlich.android.deezfoodz.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * The @Module annotation tells Dagger that the AppModule class will provide dependencies
 * for a part of the application. It is normal to have multiple Dagger modules in a project,
 * and it is typical for one of them to provide app-wide dependencies.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;
    }


    /**
     * The @Provides annotation tells Dagger that the method provides a certain type of dependency,
     * in this case, a Context object. When a part of the app requests that Dagger inject a Context,
     * the @Provides annotation tells Dagger where to find it.
     *
     * The @Singleton annotation tells Dagger that there should only be a singleton instance
     * of that dependency and removes a lot of the boilerplate singleton code for you.
     * @return
     */
    @Provides
    @Singleton
    public Context getContext(){
        return application;
    }
}
