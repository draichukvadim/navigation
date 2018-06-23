package com.navigation.vadik.navigation.view.settings

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.navigation.vadik.navigation.R
import com.navigation.vadik.navigation.db.UserEntity

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvId: TextView = view.findViewById(R.id.tvId)
    private val tvName: TextView = view.findViewById(R.id.tvName)

    private var user: UserEntity? = null

    fun bind(user: UserEntity?) {
        if (user == null) {
            tvId.text = "Loading..."
        } else {
            showUserData(user)
        }
    }

    private fun showUserData(user: UserEntity) {
        this.user = user
        tvId.text = user.id.toString()
        tvName.text = user.login
    }

    companion object {
        fun create(parent: ViewGroup): UserViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_repo_item, parent, false)
            return UserViewHolder(view)
        }
    }
}