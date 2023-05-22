package com.example.recyclerviewdiffutils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by NguyenLinh on 17,May,2023
 */
class UserAdapter(private val userList: MutableList<Users>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    fun setUserList(updatedUserList: List<Users>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffUtilCallback(userList, updatedUserList))
        userList.clear()
        userList.addAll(updatedUserList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvUserName.text = user.name
        holder.tvAddress.text = user.address
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvAddress = view.findViewById<TextView>(R.id.tvAddress)

    }
}