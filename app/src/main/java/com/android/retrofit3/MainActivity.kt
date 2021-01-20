package com.android.retrofit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.android.retrofit3.retrofit.JsonPlaceHolderApi
import com.android.retrofit3.retrofit.Post
import com.android.retrofit3.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val postService = ServiceBuilder.buildService(JsonPlaceHolderApi::class.java)

        val call = postService.getPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    text_view_result.text = ""
                    val posts: List<Post> = response.body()!!
                    for (post in posts) {
                        var content: String = ""
                        content += "ID: " + post.id + "\n"
                        content += "User ID:" + post.userId + "\n"
                        content += "Title:" + post.title + "\n"
                        content += "Text:" + post.text + "\n\n"

                        text_view_result.append(content)
                    }
                } else {
                    text_view_result.text = response.code().toString()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d(TAG, "onResponse: ${t.message}")

            }

        })
    }
}