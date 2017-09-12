package com.raywenderlich.android.deezfoodz.dagger;

import com.raywenderlich.android.deezfoodz.app.Constants;
import com.raywenderlich.android.deezfoodz.network.UsdaApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Eliminating code duplication.
 Eliminating the need for dependency configuration.
 Automatic construction of a dependency graph.
 */

@Module
public class NetworkModule {

    private static final String NAME_BASE_URL = "NAME_BASE_URL";

    /**
     *  Dagger annotation in play here, @Named.
     *  You are injecting a String object, and since String is such a common type to use in
     *  an Android app, you’ve taken advantage of the @Named annotation to specify a specific
     *  string to be provided. This same technique can be used for your own types if you need
     *  multiple variations injected.
     * @return
     */
    @Provides
    @Named(NAME_BASE_URL)
    String providesBaseUrlString(){
        return Constants.BASE_URL;
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGsonConverter(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofitObject(GsonConverterFactory converter, @Named(NAME_BASE_URL) String baseURL){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(converter)
                .build();
    }


    /**
     * You’ve added the provides methods for both a Retrofit object and a UsdaApi object.
     * This allows Dagger to construct a dependency graph, so that when an object asks for a
     * UsdaApi object to be injected, Dagger will first provide a Retrofit object to use in
     * provideUsdaApi(Retrofit retrofit).
     * Then, Dagger will continue walking up the graph to find a converter and baseUrl for
     * provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl).
     * By using the @Singleton annotations, only one instance of the UsdaApi and Retrofit
     * objects will be created and shared between both activities in the app.
     * @param retrofit
     * @return
     */
    @Provides
    @Singleton
    UsdaApi providesUsdaApi(Retrofit retrofit){
        return retrofit.create(UsdaApi.class);
    }
}
