package com.sk.splash.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.splash.data.models.UIUser
import com.sk.splash.ui.databinding.ItemUserBinding


class UserAdapter(
    onUserClicked: (UIUser) -> Unit
) : BaseListAdapter<ItemUserBinding, UserAdapter.ViewHolder, UIUser>(onUserClicked, UserDiff) {

    override fun createViewHolder(parent: ViewGroup, onItemClick: (UIUser) -> Unit): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    class ViewHolder(
        binding: ItemUserBinding,
        onUserClicked: (UIUser) -> Unit
    ) : BaseViewHolder<ItemUserBinding, UIUser>(binding, onUserClicked) {
        override fun bind(item: UIUser) {
            binding.txtName.text = item.name
            binding.txtUsername.text = "@${item.username}"
            Glide
                .with(binding.root.context)
                .load(item.profileImage?.large)
                .transform(CircleCrop())
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .into(binding.ivProfile)
            binding.root.setOnClickListener { onItemClick(item) }
        }
    }

    object UserDiff : DiffUtil.ItemCallback<UIUser>() {

        override fun areItemsTheSame(oldItem: UIUser, newItem: UIUser): Boolean {
            return oldItem.username == newItem.username
        }

        override fun areContentsTheSame(oldItem: UIUser, newItem: UIUser): Boolean {
            return oldItem == newItem
        }
    }
}