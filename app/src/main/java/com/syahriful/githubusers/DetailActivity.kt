package com.syahriful.githubusers


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syahriful.githubusers.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receive_data = intent.getParcelableExtra<User>(EXTRA_DATA) as User
        setTitle(receive_data.name)

        Glide.with(this)
            .load(receive_data.avatar)
            .apply(RequestOptions().override(355,355))
            .into(binding.imgAvatar)

        binding.tvName.text = receive_data.name
        binding.tvUsername.text = "@${receive_data.username}"
        binding.tvCompany.text = receive_data.company
        binding.tvLocation.text = receive_data.location
        binding.tvRepository.text = receive_data.repository.toString()
        binding.tvFollowers.text = receive_data.followers.toString()
        binding.tvFollowing.text = receive_data.following.toString()

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
