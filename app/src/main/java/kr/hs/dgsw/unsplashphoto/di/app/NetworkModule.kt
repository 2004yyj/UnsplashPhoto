package kr.hs.dgsw.unsplashphoto.di.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kr.hs.dgsw.unsplashphoto.api.PhotoService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson
    ) : Retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePhotoService(retrofit: Retrofit) : PhotoService = retrofit.create(PhotoService::class.java)

}