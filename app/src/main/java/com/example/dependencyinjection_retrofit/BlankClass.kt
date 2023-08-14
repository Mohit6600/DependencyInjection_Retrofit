package com.example.dependencyinjection_retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BlankClass:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blank_activity)


      /*  val sharedPreferences: SharedPreferences = getSharedPreferences("Mohit Code", Context.MODE_PRIVATE)
        val recivedUserName = sharedPreferences.getString("userName","")
        val recivedUserPassword = sharedPreferences.getString("userPassword","")

        Log.d("SharedPrefs", "Received Username: $recivedUserName, Received Password: $recivedUserPassword")

        val showUserName = findViewById<TextView>(R.id.id)
        val showUserPassword = findViewById<TextView>(R.id.title)
        showUserName.text = recivedUserName
        showUserPassword.text= recivedUserPassword*/

    }

}