package com.example.dependencyinjection_retrofit.presentation.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.dependencyinjection_retrofit.adapter.MyAdapter
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.database.AppDatabase
import com.example.dependencyinjection_retrofit.database.UserData
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.utils.LoginApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {


    val viewModel: ProductViewModel by viewModels()
    lateinit var database: AppDatabase

    lateinit var myAdapter: MyAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var btn: Button
    lateinit var textView: TextView
    lateinit var showText: TextView
    lateinit var saveBtn: Button
    lateinit var userList : ArrayList<UserData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        name = findViewById(R.id.name)
        password = findViewById(R.id.password)
        btn = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        showText = findViewById(R.id.showText)

        userList = mutableListOf<UserData>() as ArrayList<UserData>

        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "my database")
                .fallbackToDestructiveMigration().build()

        initViews()

        setObservers()

        btn.setOnClickListener {
            GlobalScope.launch {


                val username = name.text.toString()
                val userpassword = password.text.toString()

                viewModel.loginUser(username, userpassword)

            }
        }


    }


    fun initViews() {


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


    }


    /*       viewModel.productPostResponseObserver.observe(this){res ->


           when (res){

               is ApiState.Loading -> {

                   textView.text = "Loading"

               }

               is ApiState.Success -> {

                 val ourProduct = res.data ?: emptyList<ProductResponseItem>()

                   myAdapter = MyAdapter(baseContext,ourProduct)
                   recyclerView.adapter = myAdapter

               }

           }
       }
       GlobalScope.launch {

           viewModel.getProduct()
       }*/


    // this is for add product list method
    /*   fun setObservers() {

           viewModel.productPostResponseObserver.observe(this) { res ->


               when (res) {

                   is ApiState.Loading -> {

                       textView.text = "Loading"

                   }

                   is ApiState.Success -> {

                       val ourProduct = res.data
                       val list: List<ProductItem> = listOf(ourProduct)

                       myAdapter = MyAdapter(baseContext, list)
                       recyclerView.adapter = myAdapter

                   }

               }

           }

       }*/

    fun setObservers() {


        viewModel.userPostResponseObserver.observe(this) { res ->


            when (res) {

                is LoginApiState.Loading -> {

                    textView.text = "Loading"

                }

                is LoginApiState.Success -> {

                    val sharedPreference: SharedPreferences =
                        getSharedPreferences("Mohit Code", Context.MODE_PRIVATE)
                    val editor = sharedPreference.edit()
                    editor.putString("jwtToken", res.data.jwt)
                    editor.putInt("userId", res.data.user.id)
                    editor.apply()


                     val intent = Intent(applicationContext, UpdateActivity::class.java)

                     intent.putExtra("userName", res.data.user.username)
                     intent.putExtra("email", res.data.user.email)
                     startActivity(intent)


                    val ourProduct = res.data
                    /*   val list: MutableList<LoginResponse> = mutableListOf(ourProduct)*/



                      /*  =  database.userDao().getAllUser()*/

                        myAdapter = MyAdapter(applicationContext, userList)
                        recyclerView.adapter = myAdapter
                        myAdapter.notifyDataSetChanged()





                   /* Log.e("mohitcode", list.toString())*/

                    showText.text = res.data.user.username

                    Toast.makeText(applicationContext, "login Successful", Toast.LENGTH_SHORT)
                        .show()
                    textView.text = "login success"

                    database()


                }

                is LoginApiState.Error -> {

                    val user = res.data
                    textView.text = user.error.message
                }

            }

        }

    }

    fun database() {

        /*  Log.e("mohitcode","success")*/

        val username = name.text.toString()
        val password2 = password.text.toString()

        if (username.isNotEmpty() && password2.isNotEmpty()) {

            GlobalScope.launch {

                database.userDao().insertUser(UserData(null, username, password2))
                userList.clear()
                userList.addAll(database.userDao().getAllUser())


            }
        }


    }
}