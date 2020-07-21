package ru.netology.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.netology.R
import ru.netology.dto.Post
import ru.netology.dto.PostTypes.*
import ru.netology.viewholders.*
import java.util.*

class PostsRecyclerAdapter(dataSet: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Post> = dataSet
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            0 ->
                return PostBasicHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_post_basic,
                        parent,
                        false
                    )
                )
            1 ->
                return PostEventHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_post_event,
                        parent,
                        false
                    )
                )
            2 ->
                return PostVideoHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_post_video,
                        parent,
                        false
                    )
                )
            3 ->
                return PostRepostHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_post_repost,
                        parent,
                        false
                    )
                )
            4 ->
                return PostPromoHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_post_promo,
                        parent,
                        false
                    )
                )
            else -> return PostBasicHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_post_basic,
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].postType) {
            POSTBASIC -> 0
            POSTEVENT -> 1
            POSTVIDEO -> 2
            POSTREPOST -> 3
            POSTPROMO -> 4
        }
    }
}