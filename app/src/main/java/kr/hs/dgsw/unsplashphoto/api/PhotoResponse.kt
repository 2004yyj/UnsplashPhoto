package kr.hs.dgsw.unsplashphoto.api

import kr.hs.dgsw.unsplashphoto.data.Photo

data class PhotoResponse(
    val results : List<Photo>
)