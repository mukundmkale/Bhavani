package com.mukund.mvvmcodearchitecture.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.mukund.mvvmcodearchitecture.databinding.StartactivitylayoutBinding
import com.mukund.mvvmcodearchitecture.ui.activity.Base.BaseActivity
import com.mukund.mvvmcodearchitecture.viewmodel.ConfigViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import com.mukund.mvvmcodearchitecture.util.customFunction.ExtensionFunction.setOnSafeClickListener

@InternalCoroutinesApi
@AndroidEntryPoint
class StartActivity : BaseActivity() {

    private lateinit var binding: StartactivitylayoutBinding
    private val configViewModel:ConfigViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=StartactivitylayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClick()
        addObserver()
    }
    private fun setClick()
    {
        binding.callAPIBtn.setOnSafeClickListener {
configViewModel.fetchConfig()
        }
    }

    private fun addObserver()
    {
        configViewModel.config.observe(this){
if(configViewModel.config.value!=null)
            Toast.makeText(baseContext,configViewModel.config.value!!.message,Toast.LENGTH_LONG)
        }
    }
}