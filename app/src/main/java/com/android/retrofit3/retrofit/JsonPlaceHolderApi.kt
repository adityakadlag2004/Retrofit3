package com.android.retrofit3.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {

  @GET("posts")
  fun getPosts():Call<List<Post>>
}