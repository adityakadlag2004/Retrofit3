package com.android.retrofit3.retrofit

import com.google.gson.annotations.SerializedName

class Post {
    var userId:Int?=0

    var id :Int?=null

    var title:String?=null
    @SerializedName("body")
    var text:String?=null
}