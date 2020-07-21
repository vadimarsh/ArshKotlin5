package ru.netology

import ru.netology.dto.*
import ru.netology.util.Location
import java.text.SimpleDateFormat

class DataSource {

    companion object {
        fun createDataSet(): ArrayList<Post> {
            val list = ArrayList<Post>()
            list.add(
                PostBasic(
                    0,
                    "Вадим Аршинский",
                    "default",
                    "Первый пост!! Привет мир!",
                    SimpleDateFormat("dd-MM-yyyy").parse("15-07-2020")!!,
                    56,
                    100,
                    1
                )
            )
            list.add(
                PostEvent(
                    1,
                    "Вадим Аршинский",
                    "default",
                    "На острове Ольхон, который является сакральным центром силы Байкала, расположен мыс Шаманка, который является обиталещем главного бурхана всей территории",
                    SimpleDateFormat("dd-MM-yyyy").parse("17-07-2020")!!,
                    "РФ, Иркутская область, п. Хужир",
                    Location("53.203965", "107.338867"),
                    0,
                    0,
                    3
                )
            )
            list.add(
                PostVideo(
                    2,
                    "Вадим Аршинский",
                    "default",
                    "Мыс Бурхан зимой (кликните на картинку для просмотра)",
                    SimpleDateFormat("dd-MM-yyyy").parse("01-03-2020")!!,
                    "https://youtu.be/73syI1uEWsM",
                    3,
                    1,
                    3
                )
            )
            list.add(
                PostRepost(
                    3,
                    "Вадим Аршинский",
                    "default",
                    list[0],
                    "Зацените друзья: какой зачётный пост!",
                    SimpleDateFormat("dd-MM-yyyy").parse("20-07-2020")!!,
                    0,
                    0,
                    0
                )
            )
            list.add(
                PostPromo(
                    4,
                    "Гугл",
                    "https://lh4.googleusercontent.com/-JGT2qEoG5X4/AAAAAAAAAAI/AAAAAAAAHko/fH9KqPJv1Ls/photo.jpg",
                    "Очень полезный сервис!",
                    SimpleDateFormat("dd-MM-yyyy").parse("20-07-2020")!!,
                    "https://www.google.com/intl/ru/landing/now/images/gnow-cardlist-manage.jpg",
                    "https://www.google.ru/landing/now/",
                    0,
                    0,
                    0
                )
            )
            list.add(
                PostRepost(
                    5,
                    "Вадим Аршинский",
                    "default",
                    list[2],
                    "И еще один зачётный пост!",
                    SimpleDateFormat("dd-MM-yyyy").parse("20-07-2020")!!,
                    0,
                    0,
                    0
                )
            )
            return list
        }
    }
}