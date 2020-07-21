package ru.netology.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.netology.dto.Post

abstract class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(post: Post)
    abstract fun refreshPost(post: Post)
}