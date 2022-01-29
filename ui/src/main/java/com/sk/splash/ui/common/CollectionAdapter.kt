package com.sk.splash.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.splash.data.utils.models.UICollection
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
                val context = root.context
                txtTitle.text = item.title

                if (item.coverPhoto != null) {
                    val scale = context.resources.displayMetrics.density
                    val width = (root.resources.displayMetrics.widthPixels - scale * 32).toInt()
                    val height =
                        ((width) / ((item.coverPhoto!!.width.toFloat() / item.coverPhoto!!.height.toFloat()))).toInt()

                    ivPhoto.layoutParams.height = height

                    Glide
                        .with(root.context)
                        .load(item.coverPhoto!!.urls.regular)
                        .override(width, height)
                        .placeholder(ColorDrawable(Color.parseColor(item.coverPhoto!!.color)))
                        .transition(DrawableTransitionOptions.withCrossFade(200))
                        .into(ivPhoto)

                    root.setOnClickListener {
                        onItemClick(item)
                    }
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