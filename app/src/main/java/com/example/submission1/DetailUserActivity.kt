package com.example.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailUserActivity : AppCompatActivity() {
    companion object {
        const val USER = "user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val userAvatar:ImageView = findViewById(R.id.detail_avatar)
        val userUsername:TextView = findViewById(R.id.detail_username)
        val userName:TextView = findViewById(R.id.detail_name)
        val userDesc:TextView = findViewById(R.id.detail_description)

        supportActionBar?.title = "Detail User"

        val user = intent.getParcelableExtra<User>(USER) as User
        Glide.with(this)
            .load(user.avatar)
            .circleCrop()
            .into(userAvatar)
        userUsername.text = user.username
        userName.text = user.name
        val followers = user.followers
        val following = user.following
        val location = user.location
        val company = user.company
        val repos = user.repository
        val descPlaceholder = "Followers: %s\nFollowing: %s\nRepository: %s\nLocation: %s\nCompany: %s"
        userDesc.text = String.format(descPlaceholder, followers, following, repos, location, company)
    }
}