package com.syahriful.githubusers

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syahriful.githubusers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var username: Array<String>
    private lateinit var name: Array<String>
    private lateinit var location: Array<String>
    private lateinit var repository: Array<String>
    private lateinit var company: Array<String>
    private lateinit var followers: Array<String>
    private lateinit var following: Array<String>
    private lateinit var avatar: TypedArray

    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<User> = arrayListOf()
    private var title: String = "Github User App"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(title)
        binding.rViewUsers.setHasFixedSize(true)
        prepareData()
        list.addAll(loopData())

        showRecyclerCardView()
    }
    private fun prepareData(){
        username = resources.getStringArray(R.array.username)
        name = resources.getStringArray(R.array.name)
        location = resources.getStringArray(R.array.location)
        repository = resources.getStringArray(R.array.repository)
        company = resources.getStringArray(R.array.company)
        followers = resources.getStringArray(R.array.followers)
        following = resources.getStringArray(R.array.following)
        avatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun loopData(): ArrayList<User> {
        val list = arrayListOf<User>()
        for (position in username.indices){
            val githubUser = User()
            githubUser.username = username[position]
            githubUser.name = name[position]
            githubUser.location = location[position]
            githubUser.repository = repository[position].toInt()
            githubUser.company = company[position]
            githubUser.followers = followers[position].toInt()
            githubUser.following = following[position].toInt()
            githubUser.avatar = avatar.getResourceId(position, 0)
            list.add(githubUser)
        }
        return list
    }
    // fungsi utk set title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerCardView() {
        binding.rViewUsers.layoutManager = GridLayoutManager(this, 1)
        val cardViewUserAdapter = CardUserAdapter(list)
        binding.rViewUsers.adapter = cardViewUserAdapter

        cardViewUserAdapter.setOnItemClickCallback(object : CardUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                val githubUser = UserData(data)
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_DATA, githubUser)
                }
                startActivity(intent)
                showSelectedItem(data)
            }
        })
    }

    private fun UserData(data: User): User{
        return User(
                data.username,
                data.name,
                data.avatar,
                data.followers,
                data.following,
                data.company,
                data.location,
                data.repository
        )
    }

    private fun showSelectedItem(user: User) {
        Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()
    }
}