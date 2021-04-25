package kr.hs.dgsw.unsplashphoto.di.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import kr.hs.dgsw.unsplashphoto.di.MyApp
import kr.hs.dgsw.unsplashphoto.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<MyApp> {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application) : AppComponent
    }
}