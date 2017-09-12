Steps to implement Dagger

<ul><li>
Step 1
Initialization of Dagger ate class level done in AppModule Class & initialized at class level in Application Class (DeezFoodzApplication)
protected AppComponent initDagger(DeezFoodzApplication application){
    return DaggerAppComponent.builder()
            .appModule(new AppModule(application))
            .build();
  }
</li>
<li>
Step 2
Create a class with @Module(Class Level) annotation & @Provides(Method level) annotations.
This step is to identify classes/objects which can be ideal candidates for dependency injection. The ideal candidates can be a Class or methods which require code duplication across the project like Retrofit in this project for instance.
@Module - Class level
@Singleton - Method level
@Provides - Method level
@Named - tags a particular provides method of any return type like String, int, Objects, etc. This annotation type accepts String as a key and it can be accessed in any provides method through an unique key

Eg:
@Module
public class PresenterModule 

@Provides
    @Singleton
    FoodzPresenter provideFoodzPresenter(Context context){
        return new FoodzPresenterImpl(context);
    }
</li>

<li>STEP 3: Create an interface for a Component. 
Eg:
@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {

 void inject (FoodzActivity target);</li>

<li>STEP 4: Now it’s time to bind Dagger 2 into Application class.</li>
</ul>
