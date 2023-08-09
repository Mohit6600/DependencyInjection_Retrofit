package com.example.dependencyinjection_retrofit.Presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection_retrofit.Adapter.MyAdapter
import com.example.dependencyinjection_retrofit.Presentation.viewModels.ProductViewModel
import com.example.dependencyinjection_retrofit.Retrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.Retrofit.utils.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    val viewModel: ProductViewModel by viewModels()

    lateinit var myAdapter: MyAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
        setObservers()

        GlobalScope.launch {

            viewModel.addProduct()
        }


    }


    fun initViews() {

        textView = findViewById(R.id.textView)


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

    fun setObservers() {

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

    }
}


