package com.navigation.vadik.navigation.view.settings

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.navigation.vadik.navigation.db.UserEntity


class UserAdapter : PagedListAdapter<UserEntity, UserViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder.create(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                    oldItem == newItem
        }
    }

}