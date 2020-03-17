package com.example.retrofithw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofithw.adapter.PostsAdapter
import com.example.retrofithw.api.PostsApiInterface
import com.example.retrofithw.model.Posts
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPost()
    }


    fun loadUserList(postLIst: List<Posts>) {

        recyclerqueen.apply {
            layoutManager = LinearLayoutManager(context)
            val postAdapter = PostsAdapter(postLIst)

            adapter = postAdapter

        }
    }

    fun getPost() {
        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService = retrofit.create(PostsApiInterface::class.java)
        var apiCall = retrofitService.getPosts()
        apiCall.enqueue(object : Callback<List<Posts>> {
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                var postList = response.body()
                loadUserList(postList!!)
            }

        })
    }
}
