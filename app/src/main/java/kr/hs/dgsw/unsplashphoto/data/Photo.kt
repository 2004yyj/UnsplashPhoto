package kr.hs.dgsw.unsplashphoto.data

data class Photo(
    val id: String,
    val title: String?,
    val user : PhotoUser,
    val urls: PhotoUrls
) {
    data class PhotoUser(
        val name : String,
        val username : String
    )

    data class PhotoUrls(
        val raw : String,
        val full : String,
        val regular : String,
        val small : String,
        val thumb : String
    )
}