package kr.hs.dgsw.unsplashphoto

import android.util.Log
import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Completable.error
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kr.hs.dgsw.unsplashphoto.api.PhotoService
import kr.hs.dgsw.unsplashphoto.data.Photo

class PhotoPagingSource(
    private val photoService: PhotoService,
    private val query: String
) : RxPagingSource<Int, Photo>() {

    private val TAG = "PhotoPagingSource"

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Photo>> {
        val page = params.key ?: 1

        return photoService.searchPhotos(query, page, params.loadSize)
            .subscribeOn(Schedulers.io())
            .map {
                Log.d(TAG, "loadSingle: ${it.results}")
                LoadResult.Page(
                    data = it.results,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (page == params.loadSize) null else page + 1,
                ) as LoadResult<Int, Photo>
            }
            .onErrorReturn {
                LoadResult.Error(it)
            }
    }
}