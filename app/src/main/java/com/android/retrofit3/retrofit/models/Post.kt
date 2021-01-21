package com.android.retrofit3.retrofit.models

import com.google.gson.annotations.SerializedName

class Post(
    var userId: Int?,
    var title: String?,
    @SerializedName("body") var text: String?,
    var id: Int? = null
) {


}