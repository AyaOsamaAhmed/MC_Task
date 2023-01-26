package com.aya.mc_task.feature.fragment.home.domain

import com.aya.mc_task.core.response.ErrorResponse
import com.aya.mc_task.core.response.NetworkResponse
import com.aya.mc_task.core.usecase.BaseUseCase
import com.aya.mc_task.feature.fragment.home.data.HomeItem
import com.aya.mc_task.feature.fragment.home.data.HomeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeUseCase  @Inject constructor(private val mainRepository: MainRepository) :
    BaseUseCase<HomeResponse,  HomeItem, Any>() {
    override fun mapper(req: HomeResponse): HomeItem =
       HomeMapper.mapData(req)

    override fun executeRemote(params: Any?): Flow<NetworkResponse<HomeResponse, ErrorResponse>> =
        flow {
            emit(mainRepository.homePage())
        }
}