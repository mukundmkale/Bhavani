package com.mukund.mvvmcodearchitecture.model.basemodel

import com.google.gson.annotations.SerializedName

class Response<T> {
    @SerializedName("success")
    val success: Boolean = false

    @SerializedName("event")
    val event : String  = ""

    @SerializedName("message")
    val message: String? = null

    @SerializedName("data")
    val data : T ?= null

}