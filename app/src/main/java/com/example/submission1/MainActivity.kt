package com.example.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "GitHub User's"

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val name = resources.getStringArray(R.array.name)
            val username = resources.getStringArray(R.array.username)
            val location = resources.getStringArray(R.array.location)
            val repository = resources.getStringArray(R.array.repository)
            val company = resources.getStringArray(R.array.company)
            val followers = resources.getStringArray(R.array.followers)
            val following = resources.getStringArray(R.array.following)
            val avatar = resources.obtainTypedArray(R.array.avatar)
            val listUser = ArrayList<User>()
            for (i in name.indices) {
                val user = User(username[i], name[i], location[i], repository[i], company[i], followers[i], following[i], avatar.getResourceId(i, -1))
                listUser.add(user)
            }
            avatar.recycle()
            return listUser
        }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserUpdater = ListUserAdapter(list, this)
        rvUsers.adapter = listUserUpdater
    }
}