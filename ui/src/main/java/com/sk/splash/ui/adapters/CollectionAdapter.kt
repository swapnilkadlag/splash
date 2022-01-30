package com.sk.splash.ui.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.splash.data.models.UICollection
import com.sk.splash.ui.databinding.ItemCollectionBinding

class CollectionAdapter(
    onCollectionClicked: (UICollection) -> Unit,
) : BaseListAdapter<ItemCollectionBinding, CollectionAdapter.ViewHolder, UICollection>(
    onCollectionClicked,
    CollectionListDiff,
) {
    override fun createViewHolder(
        parent: ViewGroup,
        onItemClick: (UICollection) -> Unit,
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCollectionBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    class ViewHolder(
        binding: ItemCollectionBinding,
        onCollectionClicked: (UICollection) -> Unit,
    ) : BaseViewHolder<ItemCollectionBinding, UICollection>(binding, onCollectionClicked) {

        override fun bind(item: UICollection) {
            with(binding) {
                val cover = item.coverPhoto
                if (cover != null) {
                    val aspect = cover.height / cover.width.toFloat()
                    binding.ivPhoto.setAspectRatio(aspect)
                    Glide
                        .with(binding.root.context)
                        .load(cover.urls.regular)
                        .placeholder(ColorDrawable(Color.parseColor(cover.color)))
                        .transition(DrawableTransitionOptions.withCrossFade(200))
                        .into(binding.ivPhoto)
                        .waitForLayout()
                }
                txtTitle.text = item.title

                root.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }

    object CollectionListDiff : DiffUtil.ItemCallback<UICollection>() {
        override fun areItemsTheSame(oldItem: UICollection, newItem: UICollection): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UICollection, newItem: UICollection): Boolean {
            return oldItem == newItem
        }
    }
}