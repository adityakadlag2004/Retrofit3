package com.android.retrofit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.android.retrofit3.retrofit.api.JsonPlaceHolderApi
import com.android.retrofit3.retrofit.models.Post
import com.android.retrofit3.retrofit.ServiceBuilder
import com.android.retrofit3.retrofit.models.Comment
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

//        val hash=HashMap<String,String>()
//        hash["userId"] = "1"
//        hash["_sort"] = "id"
//        hash["_order"] = "desc"
//        getPosts(hash)
        // getComments(8)

        updatePost()
       // createPost()
    }

    private fun createPost() {
        val post = Post(2, "New Title", "New Post")
        val postService = ServiceBuilder.buildService(JsonPlaceHolderApi::class.java)

        val call = postService.createPost(post)
        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    text_view_result.text = ""
                    val posts: Post = response.body()!!
                    var content = ""
                    content += "ID: " + posts.id + "\n"
                    content += "User ID:" + posts.userId + "\n"
                    content += "Title:" + posts.title + "\n"
                    content += "Text:" + posts.text + "\n\n"
                    text_view_result.append(content)

                } else {
                    text_view_result.text = response.code().toString()
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }


        })


    }
    private fun getPosts(hash: HashMap<String, String>) {
        val postService = ServiceBuilder.buildService(JsonPlaceHolderApi::class.java)
        val call = postService.getPosts(hash)
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    text_view_result.text = ""
                    val posts: List<Post> = response.body()!!
                    for (post in posts) {
                        var content = ""
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
    fun getComments(id: Int) {
        val postService = ServiceBuilder.buildService(JsonPlaceHolderApi::class.java)
        val call = postService.getComments(id)

        call.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful) {
                    val comments: List<Comment> = response.body()!!
                    for (com in comments) {
                        var content = ""
                        content += "ID: " + com.getId() + "\n"
                        content += "User ID:" + com.getId() + "\n"
                        content += "Title:" + com.getName() + "\n"
                        content += "Text:" + com.getText() + "\n\n"
                        text_view_result.append(content)
                    }
                } else {
                    text_view_result.text = response.code().toString()
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    private fun updatePost() {
        val post = Post(12, null, "New Updated Post")
        val postService = ServiceBuilder.buildService(JsonPlaceHolderApi::class.java)

        val call = postService.patchPost(2,post)
        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    text_view_result.text = ""
                    val posts: Post = response.body()!!
                    var content = ""
                    content += "ID: " + posts.id + "\n"
                    content += "User ID:" + posts.userId + "\n"
                    content += "Title:" + posts.title + "\n"
                    content += "Text:" + posts.text + "\n\n"
                    text_view_result.text=content

                } else {
                    text_view_result.text = response.code().toString()
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }


        })


    }

}