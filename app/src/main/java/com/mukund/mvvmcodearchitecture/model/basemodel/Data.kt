package com.mukund.mvvmcodearchitecture.model.basemodel

import com.google.gson.annotations.SerializedName

class Data<T> {
    @SerializedName("result")
    val result : ArrayList<T> ? = null
}