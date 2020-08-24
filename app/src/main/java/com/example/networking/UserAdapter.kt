package com.example.networking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter {

    private var data: List<User> = ArrayList()
    var onItemClick: ((login: String) -> Unit)? = null

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )
    }

    fun getItemCount() = data.size

     fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(data[position])



    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: User) = with(itemView) {
            textView.text = item.name as CharSequence?
            textView1.text = item.login
            Picasso.get().load(item.avatarUrl).into(imageView)

            setOnClickListener {
                onItemClick?.invoke(item.login!!)
            }
        }
    }
}