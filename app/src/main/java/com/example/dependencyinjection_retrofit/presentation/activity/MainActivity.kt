package com.example.dependencyinjection_retrofit.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection_retrofit.BlankClass
import com.example.dependencyinjection_retrofit.adapter.MyAdapter
import com.example.dependencyinjection_retrofit.presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.retrofit.response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.utils.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    val viewModel: ProductViewModel by viewModels()

    lateinit var myAdapter: MyAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var saveBtn: Button
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        name = findViewById(R.id.name)
        password = findViewById(R.id.password)
         saveBtn = findViewById(R.id.button)
         textView = findViewById(R.id.textView)

        /* initViews()*/
        setObservers()

         GlobalScope.launch {

             viewModel.loginUser("mohit6600","mohit123")
         }


    }


    /* fun initViews() {

         textView = findViewById(R.id.textView)


         recyclerView = findViewById(R.id.recyclerView)
         recyclerView.setHasFixedSize(true)
         linearLayoutManager = LinearLayoutManager(this)
         recyclerView.layoutManager = linearLayoutManager


     }*/


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

                is ApiState.Loading -> {

                    textView.text = "Loading"

                }

                is ApiState.Success -> {

                    val user = res.data

                }

                is ApiState.Error -> {

                    val user = res.data
                    textView.text = user.error.message
                }


            }

        }

    }
}


