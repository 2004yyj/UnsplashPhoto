package kr.hs.dgsw.unsplashphoto.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kr.hs.dgsw.unsplashphoto.R
import kr.hs.dgsw.unsplashphoto.data.Photo
import kr.hs.dgsw.unsplashphoto.databinding.ItemUnsplashPhotoBinding

class PhotoAdapter : PagingDataAdapter<Photo, PhotoAdapter.ViewHolder>(diffCallback) {

    inner class ViewHolder(private val binding : ItemUnsplashPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.apply {
                Glide.with(itemPhotoImageView.context)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_baseline_error_24)
                    .into(itemPhotoImageView)

                itemUsernameTextView.text = photo.user.username
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val photo = getItem(position)

        if (photo != null) {
            holder.bind(photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_unsplash_photo, parent, false))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                oldItem == newItem
        }
    }
}