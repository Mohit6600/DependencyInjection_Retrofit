package com.example.dependencyinjection_retrofit.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.retrofit.utils.ApiState
import com.example.dependencyinjection_retrofit.retrofit.utils.RegisterApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.userAgent

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    val registerViewModel: ProductViewModel by viewModels()
    lateinit var emailEdt: EditText
    lateinit var userNameEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var registerBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initViews()
        setObserver()
        sendApiRequest()
    }

    private fun initViews() {
        registerBtn = findViewById(R.id.registerBtn)
        passwordEdt = findViewById(R.id.passwordEdt)
        emailEdt = findViewById(R.id.emailEdt)
        userNameEdt = findViewById(R.id.usernameEdt)

        registerBtn.setOnClickListener {
            GlobalScope.launch {
                registerViewModel.registerUser(
                    "${userNameEdt.text}",
                    "${emailEdt.text}",
                    "${passwordEdt.text}"
                )
            }
        }
    }

    private fun sendApiRequest() {


    }

    private fun setObserver() {

        registerViewModel.userRegisterResponseObserver.observe(this) { res ->


            when (res) {

                is RegisterApiState.Loading -> {

                    Log.e("Registerapi", "Loading..")
                    registerBtn.text = "Please wait.."

                }

                is RegisterApiState.Success -> {


                    Toast.makeText(this, "Account Registered Succcessfully", Toast.LENGTH_SHORT)
                        .show()
                    registerBtn.text = "Register"
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                is RegisterApiState.Error -> {
                    registerBtn.text = "Register"
                    Toast.makeText(this, res.data.error.message, Toast.LENGTH_SHORT).show()

                }


            }

        }
    }
}