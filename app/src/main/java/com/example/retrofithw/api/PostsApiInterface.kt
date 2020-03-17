package com.example.retrofithw.api

import com.example.retrofithw.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface PostsApiInterface {
    @GET(value = "posts")
    fun getPosts():Call<List<Posts>>
}