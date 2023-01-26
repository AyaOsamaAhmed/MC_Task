package com.aya.mc_task.feature.fragment.home.domain

import com.aya.mc_task.core.network.MainApis
import com.aya.mc_task.core.response.ErrorResponse
import com.aya.mc_task.core.response.NetworkResponse
import com.aya.mc_task.feature.fragment.home.data.HomeResponse
import javax.inject.Inject

class MainRepository @Inject constructor(private val mainApiService: MainApis) {

    //home
    suspend fun homePage(): NetworkResponse<HomeResponse, ErrorResponse> =
        mainApiService.getData()


}