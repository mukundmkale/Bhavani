package com.mukund.mvvmcodearchitecture.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class TokenInterceptor() : Interceptor {
    private val excludedEndpoints: MutableList<String>

    init {
        excludedEndpoints = ArrayList()
        excludedEndpoints.add(Urls.ENDPOINT_SESSION)
        // Add more endpoints as needed
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        if (!shouldAddAppToken(originalRequest.url.toString(), originalRequest.method)) {
            return chain.proceed(originalRequest)
        }
        //val appToken: String = SharedPreferenceManager.getAppToken(context)
        val modifiedRequest = originalRequest.newBuilder()
        //    .header("Authorization", "Bearer $appToken")
            .build()
        return chain.proceed(modifiedRequest)
    }

    private fun shouldAddAppToken(url: String, method: String): Boolean {
        for (excludedEndpoint in excludedEndpoints) {
            if (url.contains(excludedEndpoint) && method.matches("POST".toRegex())) {
                return false
            }
        }
        return true
    }
}
