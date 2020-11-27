package com.dilusha.mobileapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.dilusha.mobileapplication.posts.PostAdapter
import com.dilusha.mobileapplication.posts.api.PostApi
import com.dilusha.mobileapplication.posts.models.Post
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val geson = GsonBuilder().create();
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postAPI = retrofit.create(PostApi::class.java)
        val postCall = postAPI.posts
        postCall.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("MainActivity2", t.message.toString())
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val listView = findViewById<ListView>(R.id.ListViewArea)
                val adapter = PostAdapter(this@MainActivity2, response.body() as ArrayList<Post>)
                listView.adapter = adapter
                Log.d("MainActivity2", "Success")
            }
        })
    }
}