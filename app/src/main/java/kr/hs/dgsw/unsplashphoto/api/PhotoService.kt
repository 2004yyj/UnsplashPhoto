package kr.hs.dgsw.unsplashphoto.api

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotoService {

    @Headers("Accept-Version: v1", "Authorization: Client-ID _oHgo-DK1DkOod4YFsxyi9idCz2NOsDA-TVYj-vYWC4")
    @GET("search/photos")
    fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per-page") perPage: Int
    ) : Single<PhotoResponse>
}