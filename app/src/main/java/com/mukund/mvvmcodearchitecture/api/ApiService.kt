package com.mukund.mvvmcodearchitecture.api

import com.mukund.mvvmcodearchitecture.model.basemodel.Data
import com.mukund.mvvmcodearchitecture.model.basemodel.Response
import com.mukund.mvvmcodearchitecture.model.confing.ConfingData
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET(Urls.GET_CONFIG)
    suspend fun getConfig(
        @Header("Authorization") token : String,
        @Header("client_code") client_code :String
    ) : Result<Response<Data<ConfingData>>>
}