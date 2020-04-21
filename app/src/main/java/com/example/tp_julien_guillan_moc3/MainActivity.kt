package com.example.tp_julien_guillan_moc3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var nameTextEdit: EditText
    lateinit var followingsTextEdit: EditText
    lateinit var followersTextEdit: EditText
    lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.nameTextEdit = findViewById<EditText>(R.id.nameTextEdit)
        this.followingsTextEdit = findViewById<EditText>(R.id.followingTextEdit)
        this.followersTextEdit = findViewById<EditText>(R.id.followersTextEdit)
        this.submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener{
            submit()
        }
    }

    fun submit() {
        println(getName())
        println(getFollowers())
        println(getFollowings())
    }

    fun getName() : String? {
        if(this.nameTextEdit.text.length > 0){
            return this.nameTextEdit.text.toString()
        } else {
            return null
        }
    }

    fun getFollowings() : Int? {
        var followings: Int? = 0
        if(!this.followingsTextEdit.text.isEmpty()) {
            try {
                followings = this.followingsTextEdit.text.toString().toInt()
            } catch (e: Exception) {
                error(e.localizedMessage)
            }
        } else {
            toast("Please enter a value")
        }
        return followings
    }

    fun getFollowers() : Int? {
        var followers: Int? = 0
        if(!this.followersTextEdit.text.isEmpty()) {
            try {
                followers = this.followersTextEdit.text.toString().toInt()
            } catch (e: Exception) {
                error(e.localizedMessage)
            }
        } else {
            toast("please enter a value")
        }
        return followers
    }

    fun toast(message: String){
        val myToast = Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT)
        myToast.show()
    }
}
