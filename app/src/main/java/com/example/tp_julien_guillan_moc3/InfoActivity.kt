package com.example.tp_julien_guillan_moc3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.NumberFormatException

class InfoActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var followingTextView: TextView
    lateinit var followerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        nameTextView = findViewById<TextView>(R.id.nameTextView)
        followingTextView = findViewById<TextView>(R.id.followingTextView)
        followerTextView = findViewById<TextView>(R.id.followerTextView)
        setData()
    }

    fun setData(){
        val name = intent.getStringExtra("name")
        val followings: Int
        val followers: Int
        try {
            followings = intent.getIntExtra("followings", 0)
            followers = intent.getIntExtra("followers", 0)
        } catch (e: NumberFormatException){
            error(e.localizedMessage)
        }
        this.nameTextView.text = name
        this.followingTextView.text = followings.toString()
        this.followerTextView.text = followers.toString()
    }
}
