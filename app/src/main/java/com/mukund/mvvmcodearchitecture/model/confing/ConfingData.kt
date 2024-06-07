package com.mukund.mvvmcodearchitecture.model.confing

data class ConfingData(
    var category_id: Int,
    var config_key: String,
    var config_name: String,
    var data: ArrayList<DataValue>
)


data class DataValue(
    var id: Int,
    val value: String
)
