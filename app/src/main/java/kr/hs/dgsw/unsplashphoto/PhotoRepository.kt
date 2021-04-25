package kr.hs.dgsw.unsplashphoto

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.paging.rxjava2.flowable
import androidx.paging.rxjava2.observable
import kr.hs.dgsw.unsplashphoto.api.PhotoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(
    private val photoService: PhotoService
) {
    fun getPhotos(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { PhotoPagingSource(photoService, query) }
        ).observable
}