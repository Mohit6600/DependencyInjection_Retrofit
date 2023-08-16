package com.example.dependencyinjection_retrofit.presentation.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.database.AppDatabase
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.retrofit.utils.UpdateApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpdateActivity : AppCompatActivity() {

    val updateViewModel: ProductViewModel by viewModels()

    lateinit var updateName: EditText
    lateinit var updatePassword: EditText
    lateinit var updateEmail: EditText
    lateinit var updateBtn: Button
    lateinit var database: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_activity)



        init()
        setObserver()

    }

    private fun init() {

        updateEmail = findViewById(R.id.email)
        updatePassword = findViewById(R.id.passwordBox)
        updateName = findViewById(R.id.nameBox)
        updateBtn = findViewById(R.id.updateBtn)

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("Mohit Code", Context.MODE_PRIVATE)
        val jwtToken = sharedPreferences.getString("jwtToken", "")

        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "my database").build()

        val intent = intent

        val username = intent.getStringExtra("userName")
        val email = intent.getStringExtra("email")

        updateName.setText(username)
        updateEmail.setText(email)



        updateBtn.setOnClickListener {

            GlobalScope.launch {

                updateViewModel.updateUser(
                    "${updateEmail.text}",
                    "${updatePassword.text}",
                    "${updateName.text}",
                    "$jwtToken",
                    20

                )

                Log.d("shubham",jwtToken.toString())

            }

        }


    }


    private fun setObserver() {

        updateViewModel.updatePostResponseObserver.observe(this) { res ->

            when (res) {

                is UpdateApiState.Loading -> {

                    Toast.makeText(applicationContext, "Please Wait....", Toast.LENGTH_SHORT).show()

                }

                is UpdateApiState.Success -> {


                    Toast.makeText(
                        applicationContext,
                        "User Update Successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                }

                is UpdateApiState.Error -> {

                    val user = res.data

                    Toast.makeText(applicationContext, user.error.message, Toast.LENGTH_SHORT)
                        .show()


                }

            }


        }

    }


}