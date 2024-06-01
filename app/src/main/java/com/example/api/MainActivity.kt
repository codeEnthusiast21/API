package com.example.api

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview:RecyclerView
    lateinit var myAdapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         recyclerview = findViewById(R.id.recycler_View)

        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitdata = retrofitBuilder.getProductDetails()
        //enqueue k andar ctrl+shift+space
        retrofitdata.enqueue(object : Callback<mydata?> {
            override fun onResponse(p0: Call<mydata?>, p1: Response<mydata?>) {
                var responsebody = p1.body()
                var productlist = responsebody?.products!!
                myAdapter=MyAdapter(this@MainActivity,productlist)
                recyclerview.adapter=myAdapter
                recyclerview.layoutManager= LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(p0: Call<mydata?>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        })



        }
    }

//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import com.example.api.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    lateinit var recyclerview: RecyclerView
//    lateinit var myAdapter: MyAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // Ensure this matches your XML file name
//
//        recyclerview = findViewById(R.id.recycler_View)
//
//        val retrofitBuilder = Retrofit.Builder()
//            .baseUrl("https://dummyjson.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiInterface::class.java)
//
//        val retrofitdata = retrofitBuilder.getProductDetails()
//        retrofitdata.enqueue(object : Callback<mydata?> {
//            override fun onResponse(p0: Call<mydata?>, p1: Response<mydata?>) {
//                val responsebody = p1.body()
//                val productlist = responsebody?.products ?: return
//                myAdapter = MyAdapter(this@MainActivity, productlist)
//                recyclerview.adapter = myAdapter
//                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
//            }
//
//            override fun onFailure(p0: Call<mydata?>, p1: Throwable) {
//                // Handle failure
//            }
//        })
//    }
//}
