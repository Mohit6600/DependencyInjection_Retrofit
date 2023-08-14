package com.example.dependencyinjection_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.retrofit.utils.ApiState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {


    val viewModel: ProductViewModel by viewModels()

    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var email : EditText

    lateinit var saveBtn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        name = findViewById(R.id.nameBox)
        password = findViewById(R.id.passwordBox)
        saveBtn = findViewById(R.id.addUser)
        email = findViewById(R.id.email)


        setObservers1()


        GlobalScope.launch {

            saveBtn.setOnClickListener {


                val username = name.text.toString()
                val userpassword = password.text.toString()
                val email1 = email.text.toString()


                Log.d("singh", username)
                viewModel.registerUser(username, userpassword , email1)


            }
        }



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

    fun setObservers1() {


        viewModel.userPostResponseObserver.observe(this) { res ->


            when (res) {

                is ApiState.Loading -> {

                  Toast.makeText(applicationContext,"Loading",Toast.LENGTH_SHORT).show()

                }

                is ApiState.Success -> {

                    val user = res.data

                    val intent = Intent(applicationContext, BlankClass::class.java)
                    startActivity(intent)

                    Toast.makeText(applicationContext, "login Successful", Toast.LENGTH_SHORT)
                        .show()



                }

                is ApiState.Error -> {

                    val user = res.data
                    Toast.makeText(applicationContext,user.error.message,Toast.LENGTH_SHORT).show()

                }

            }

        }

    }

        }





