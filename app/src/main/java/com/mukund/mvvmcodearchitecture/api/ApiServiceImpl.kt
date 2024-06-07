package com.mukund.mvvmcodearchitecture.api

import com.mukund.mvvmcodearchitecture.util.Constants
import javax.inject.Inject

class ApiServiceImpl(@Inject private val apiService: ApiService) {

    suspend fun getConfig() = apiService.getConfig(Constants.TOKEN,Constants.CLIENT_NAME)
}