package com.example.dependencyinjection_retrofit.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
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

                    val intent = Intent(applicationContext, LoginActivity::class.java)
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





