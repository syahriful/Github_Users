package com.syahriful.githubusers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<User> = arrayListOf()
    private var title: String = "Github User App"
    private lateinit var rviewUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rviewUser = findViewById(R.id.rView_Users)
        rviewUser.setHasFixedSize(true)

        showRecyclerCardView()
    }
    // fungsi utk set title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerCardView() {
        rviewUser.layoutManager = GridLayoutManager(this, 2)
        val cardViewUserAdapter = CardUserAdapter(list)
        rviewUser.adapter = cardViewUserAdapter

        cardViewUserAdapter.setOnItemClickCallback(object : CardUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_PHOTO, data.avatar)
                }

                startActivity(intent)

                showSelectedLang(data)
            }
        })
    }

    private fun showSelectedLang(user: User) {
        Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()
    }
}