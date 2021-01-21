package com.android.retrofit3.retrofit

import com.android.retrofit3.retrofit.models.Comment
import com.android.retrofit3.retrofit.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface JsonPlaceHolderApi {

//  @GET("posts")
//  fun getPosts(
//    @Query("userId") userId:Array<Int>,
//    @Query("_sort") _sort:String?=null,
//    @Query("_order") order:String?=null
//  ):Call<List<Post>>


  @GET("posts")
  fun getPosts(
    @QueryMap map:HashMap<String,String>
  ):Call<List<Post>>

  @GET("posts/{id}/comments")
  fun getComments(@Path("id")postID:Int):Call<List<Comment>>


}