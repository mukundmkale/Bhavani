package com.mukund.mvvmcodearchitecture.repository

import com.mukund.mvvmcodearchitecture.api.ApiServiceImpl
import com.mukund.mvvmcodearchitecture.model.basemodel.Data
import com.mukund.mvvmcodearchitecture.model.basemodel.Response
import com.mukund.mvvmcodearchitecture.model.confing.ConfingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ConfigRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getConfigData(): Flow<Response<Data<ConfingData>>>  = flow {
        apiServiceImpl.getConfig().onSuccess {
            emit(it)
        }
            .onFailure {

            }
    }.flowOn(Dispatchers.IO).conflate()
}