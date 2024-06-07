package com.mukund.mvvmcodearchitecture.model.basemodel

import com.google.gson.annotations.SerializedName

class DataJSONObject<T> {
    @SerializedName("result")
    val result : T? = null
}