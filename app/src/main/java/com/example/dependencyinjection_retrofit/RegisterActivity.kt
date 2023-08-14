package com.example.dependencyinjection_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencyinjection_retrofit.presentation.activity.MainActivity
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.retrofit.utils.LoginApiState
import com.example.dependencyinjection_retrofit.retrofit.utils.RegisterApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {


    val registerViewModel: ProductViewModel by viewModels()

    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var email: EditText

    lateinit var registerBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)



        initViews()
        setObservers1()



        /*    database = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"my database").build()


            addUser = findViewById(R.id.addUser)
            nameBox = findViewById(R.id.nameBox)
            passwordBox = findViewById(R.id.passwordBox)
            phoneNo = findViewById(R.id.phoneNo)

            addUser.setOnClickListener{

              *//*  if (!nameBox.text.toString().isEmpty() && !passwordBox.text.toString().isEmpty()){*//*

                val username = nameBox.text.toString()
                val password = passwordBox.text.toString()
                val phoneNo1 = phoneNo.text.toString()


                GlobalScope.launch {

               database.userDao().insertUser(UserData(username,password,phoneNo1))


                    database.userDao().getAllUser()

                    Log.e("mohit", database.userDao().getAllUser().toString())

                }*/


    }


    private fun initViews() {

        name = findViewById(R.id.nameBox)
        password = findViewById(R.id.passwordBox)
        registerBtn = findViewById(R.id.registerBtn)
        email = findViewById(R.id.email)

        registerBtn.setOnClickListener {

            GlobalScope.launch {

                val username = name.text.toString()
                val userpassword = password.text.toString()
                val email1 = email.text.toString()
                registerViewModel.registerUser(username, userpassword, email1)


            }
        }

    }




    fun setObservers1() {


        registerViewModel.registerPostResponseObserver.observe(this) { res ->


            when (res) {

                is RegisterApiState.Loading -> {

                    registerBtn.text = "please wait...."
                    Toast.makeText(applicationContext, "Loading", Toast.LENGTH_SHORT).show()

                }

                is RegisterApiState.Success -> {

                    registerBtn.text = "Register"

                    Toast.makeText(
                        applicationContext,
                        "Account Registered Successful",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)

                }

                is RegisterApiState.Error -> {

                    registerBtn.text = "Error"
                    val user = res.data
                    Toast.makeText(applicationContext, user.error.message, Toast.LENGTH_SHORT)
                        .show()

                }

            }

        }

    }

}





