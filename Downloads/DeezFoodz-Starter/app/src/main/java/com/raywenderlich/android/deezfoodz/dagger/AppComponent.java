package com.raywenderlich.android.deezfoodz.dagger;

import com.raywenderlich.android.deezfoodz.ui.food.FoodActivity;
import com.raywenderlich.android.deezfoodz.ui.food.FoodPresenterImpl;
import com.raywenderlich.android.deezfoodz.ui.foodz.FoodzActivity;
import com.raywenderlich.android.deezfoodz.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * AppComponent is a singleton component interface for the app.
 * The @Component annotation takes a list of modules as an input
 */

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {
    void inject (FoodzActivity target);
    void inject(FoodActivity target);
    void inject(FoodPresenterImpl target);
    void inject(FoodzPresenterImpl target);
}
