package com.android.retrofit3.retrofit.models

import com.google.gson.annotations.SerializedName




class Comment {
    private val postId = 0
    private val id = 0
    private val name: String? = null
    private val email: String? = null

    @SerializedName("body")
    private val text: String? = null

    fun getPostId(): Int {
        return postId
    }

    fun getId(): Int {
        return id
    }

    fun getName(): String? {
        return name
    }

    fun getEmail(): String? {
        return email
    }

    fun getText(): String? {
        return text
    }
}