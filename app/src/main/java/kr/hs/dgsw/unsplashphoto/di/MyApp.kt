package kr.hs.dgsw.unsplashphoto.di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kr.hs.dgsw.unsplashphoto.di.app.AppComponent
import kr.hs.dgsw.unsplashphoto.di.app.DaggerAppComponent

class MyApp : DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create(this@MyApp)
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}