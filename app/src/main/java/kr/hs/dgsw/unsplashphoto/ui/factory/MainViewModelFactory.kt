package kr.hs.dgsw.unsplashphoto.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.unsplashphoto.PhotoRepository
import kr.hs.dgsw.unsplashphoto.ui.viewmodel.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val photoRepository: PhotoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(photoRepository) as T
    }
}