package kr.hs.dgsw.unsplashphoto.ui.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kr.hs.dgsw.unsplashphoto.PhotoRepository
import kr.hs.dgsw.unsplashphoto.data.Photo

class MainViewModel(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _trendingPhotos = MutableLiveData<PagingData<Photo>>()
    val trendingPhotos: LiveData<PagingData<Photo>>
        get() = _trendingPhotos

    init {

    }

    fun setQuery(query: String) {
        photoRepository.getPhotos(query)
            .cachedIn(viewModelScope)
            .subscribe {
                _trendingPhotos.value = it
            }.apply {
                compositeDisposable.add(this)
            }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}