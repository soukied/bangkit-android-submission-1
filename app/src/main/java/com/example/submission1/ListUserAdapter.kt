package com.example.submission1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListUserAdapter(private val listUser: ArrayList<User>, private val context: MainActivity): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View, context: MainActivity) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var avatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var name : TextView = itemView.findViewById(R.id.tv_item_name)
        var username: TextView = itemView.findViewById(R.id.tv_item_username)
        var user: User? = null
        var context = itemView
        private val mcon = context
        override fun onClick(v: View?) {
            val detailUserIntent = Intent(mcon, DetailUserActivity::class.java)
            detailUserIntent.putExtra(DetailUserActivity.USER, user)
            this.mcon.startActivity(detailUserIntent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.username.text = user.username
        holder.name.text = user.name
        holder.user = user
        holder.context.setOnClickListener(holder)
        Glide.with(holder.context)
            .load(user.avatar)
            .circleCrop()
            .into(holder.avatar)
    }

    override fun getItemCount(): Int = listUser.size
}