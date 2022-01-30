package com.sk.splash.ui.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.ui.databinding.ItemPhotoBinding

class PhotoAdapter(
    onPhotoClicked: (UIPhoto) -> Unit,
) : BaseListAdapter<ItemPhotoBinding, PhotoAdapter.ViewHolder, UIPhoto>(
    onPhotoClicked,
    PhotoDiff
) {
    override fun createViewHolder(parent: ViewGroup, onItemClick: (UIPhoto) -> Unit): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    inner class ViewHolder(
        binding: ItemPhotoBinding,
        onPhotoClick: (UIPhoto) -> Unit,
    ) : BaseViewHolder<ItemPhotoBinding, UIPhoto>(binding, onPhotoClick) {

        override fun bind(item: UIPhoto) {
            val aspect = item.height / item.width.toFloat()
            binding.ivPhoto.setAspectRatio(aspect)
            Glide
                .with(binding.root.context)
                .load(item.urls.small)
                .placeholder(ColorDrawable(Color.parseColor(item.color)))
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .into(binding.ivPhoto)

            binding.root.setOnClickListener { onItemClick(item) }
        }
    }

    object PhotoDiff : DiffUtil.ItemCallback<UIPhoto>() {
        override fun areItemsTheSame(oldItem: UIPhoto, newItem: UIPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UIPhoto, newItem: UIPhoto): Boolean {
            return oldItem == newItem
        }
    }
}