package com.mukund.mvvmcodearchitecture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukund.mvvmcodearchitecture.model.basemodel.Data
import com.mukund.mvvmcodearchitecture.model.basemodel.Response
import com.mukund.mvvmcodearchitecture.model.confing.ConfingData
import com.mukund.mvvmcodearchitecture.repository.ConfigRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(private val configRepository: ConfigRepository) :ViewModel(){

    private val _config: MutableLiveData<Response<Data<ConfingData>>> = MutableLiveData()

    val config=_config

    fun fetchConfig()=viewModelScope.launch {
        configRepository.getConfigData().collect{
            _config.value=it
        }
    }
}