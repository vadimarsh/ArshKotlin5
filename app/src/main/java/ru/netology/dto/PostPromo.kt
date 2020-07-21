package ru.netology.dto

import ru.netology.dto.PostTypes.POSTPROMO
import java.util.*

data class PostPromo(
    override val id: Long,
    override val author: String,
    override val avatarurl: String,
    override val content: String,
    override var created: Date,
    val urlImage: String,
    val urlPromo: String,
    override var likes: Int = 0,
    override var comments: Int = 0,
    override var shares: Int = 0,
    override var likedByMe: Boolean = false,
    override var commentedByMe: Boolean = false,
    override var sharedByMe: Boolean = false
) : Post {
    val promoCaption: String = "Рекламная запись"
    override val postType: PostTypes = POSTPROMO
}