package ru.netology.viewholders

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_post_promo.view.*
import ru.netology.R
import ru.netology.dto.Post
import ru.netology.dto.PostPromo
import ru.netology.util.verboseTime
import java.util.*

class PostPromoHolder(itemView: View) : PostHolder(itemView) {
    val avatarIv = itemView.avatarIv
    val authorTv = itemView.authorTv
    val contentTv = itemView.contentTv
    val createdTv = itemView.createdTv
    val captionTv = itemView.captionTv
    val likeButton = itemView.likeButton
    val shareButton = itemView.shareButton
    val likeTextView = itemView.likeTv
    val shareTextView = itemView.shareTv


    override fun bind(post: Post) {
        val requestOptions = RequestOptions().placeholder(R.drawable.avatar)
            .error(R.drawable.avatar)

        Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions)
            .load(post.avatarurl).into(avatarIv)
        authorTv.text = post.author
        contentTv.text = post.content

        val curentDate = Date(System.currentTimeMillis())
        val elapsed = (curentDate.time - post.created.time) / 1_000
        createdTv.text = verboseTime(elapsed)

        refreshPost(post)
        likeButton.setOnClickListener {
            if (post.likedByMe) {
                post.likes--
                post.likedByMe = false
            } else {
                post.likes++
                post.likedByMe = true
            }
            refreshPost(post)
        }

        shareButton.setOnClickListener {
            if (post.sharedByMe) {
                post.shares--
                post.sharedByMe = false
            } else {
                post.shares++
                post.sharedByMe = true
            }
            refreshPost(post)

        }
        if (post is PostPromo) {
            captionTv.text = post.promoCaption
            val requestOptionsPromo =
                RequestOptions().placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context).applyDefaultRequestOptions(requestOptionsPromo)
                .load(post.urlImage).into(itemView.contentIv)
            val uri: Uri = Uri.parse(post.urlPromo)


            itemView.contentIv.setOnClickListener {
                ContextCompat.startActivity(
                    itemView.context,
                    Intent(Intent.ACTION_VIEW).apply { this.data = uri }, null
                )
            }
        }
    }

    override fun refreshPost(post: Post) {
        val curentDate = Date(System.currentTimeMillis())
        val elapsed = (curentDate.time - post.created.time) / 1_000
        createdTv.text = verboseTime(elapsed)

        authorTv.text = post.author
        contentTv.text = post.content
        likeTextView.text = post.likes.toString()

        shareTextView.text = post.shares.toString()


        if (post.likes == 0) likeTextView.visibility = View.INVISIBLE else likeTextView.visibility =
            View.VISIBLE

        if (post.shares == 0) shareTextView.visibility =
            View.INVISIBLE else shareTextView.visibility =
            View.VISIBLE

        if (post.likedByMe) {
            likeButton.setImageResource(R.drawable.like_active)
            likeTextView.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorRed))
        } else {
            likeButton.setImageResource(R.drawable.like_inactive)
            likeTextView.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorBlack))
        }
        if (post.sharedByMe) {
            shareButton.setImageResource(R.drawable.share_active)
            shareTextView.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorRed))
        } else {
            shareButton.setImageResource(R.drawable.share)
            shareTextView.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorBlack))
        }


    }

}