package com.syahriful.githubusers

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var vImg: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvUsername: TextView
    private lateinit var tvVersion: TextView
    private lateinit var tvReleased: TextView
    private lateinit var tvNameExtension: TextView
    private lateinit var tvWebsite: TextView
    private lateinit var tvDescription: TextView


    companion object{
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_VERSION = "extra_version"
        const val EXTRA_RELEASED = "extra_released"
        const val EXTRA_NAMEEXTENSION = "extra_nameExtension"
        const val EXTRA_WEBSITE = "extra_website"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        supportActionBar?.title = title
        vImg = findViewById(R.id.img_avatar)
        tvName = findViewById(R.id.tv_name)
        tvUsername = findViewById(R.id.tv_username)
//        tvVersion = findViewById(R.id.item_version)
//        tvReleased = findViewById(R.id.item_released)
//        tvNameExtension = findViewById(R.id.item_extension)
//        tvWebsite = findViewById(R.id.item_website)
//        tvDescription = findViewById(R.id.item_description)

        vImg.setImageResource(intent.getIntExtra(EXTRA_PHOTO, 0))
        tvName.text = intent.getStringExtra(EXTRA_NAME)
        tvUsername.text = intent.getStringExtra(EXTRA_USERNAME)
//        tvVersion.text = intent.getStringExtra(EXTRA_VERSION)
//        tvReleased.text = intent.getStringExtra(EXTRA_RELEASED)
//        tvNameExtension.text = intent.getStringExtra(EXTRA_NAMEEXTENSION)
//        tvWebsite.text = intent.getStringExtra(EXTRA_WEBSITE)
//        tvDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.item_website -> {
//                val intent = Intent(Intent.ACTION_VIEW).apply {
//                    setData(Uri.parse("${intent.getStringExtra(EXTRA_WEBSITE)}"))
//                }
//                startActivity(Intent.createChooser(intent, "memilih.. "))
//            }
//        }
//    }
}
