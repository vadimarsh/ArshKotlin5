package ru.netology

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.adapters.PostsRecyclerAdapter
import ru.netology.adapters.TopSpaceingItemDecoration

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val uri = Uri.parse("https://1ps.ru/imgs/team/1ps-solomichev.jpg")
        imagev.setOnClickListener(View.OnClickListener { Glide.with(this).load(uri).centerCrop().into(imagev) })
*/

        recView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpaceingItemDecoration(10)
            addItemDecoration(topSpacingDecoration)
            adapter = PostsRecyclerAdapter(DataSource.createDataSet())
        }
    }
}
