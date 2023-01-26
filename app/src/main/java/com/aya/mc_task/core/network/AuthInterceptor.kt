package com.aya.mc_task.core.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val requestBuilder: Request.Builder = request.newBuilder()
        requestBuilder.addHeader("lang", "en")
     /*    val token = getToken()
        if (token != null)
            requestBuilder.addHeader("Authorization", "Bearer $token")
*/
        return chain.proceed(requestBuilder.build())
    }

}
