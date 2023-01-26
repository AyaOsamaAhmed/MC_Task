package com.aya.mc_task.feature.fragment.home.ui

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.aya.mc_task.base.Action
import com.aya.mc_task.base.AndroidBaseViewModel
import com.aya.mc_task.core.network.Resource
import com.aya.mc_task.feature.fragment.home.data.HomeResponse
import com.aya.mc_task.feature.fragment.home.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


sealed class HomeAction  : Action {
    data class HomeData(val data: HomeResponse) : HomeAction()
    data class ShowLoading(val show: Boolean) : HomeAction()
    data class ShowFailureMsg(val message: String?) : HomeAction()
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val homeUseCase: HomeUseCase
) : AndroidBaseViewModel<HomeAction>(app) {

    init {
        homePage()
    }

    private fun homePage() {
        homeUseCase.invoke(viewModelScope) { res ->
            when (res) {
                is Resource.Failure ->
                    produce(HomeAction.ShowFailureMsg(res.message))
                is Resource.Progress ->
                    produce(HomeAction.ShowLoading(res.loading))
                is Resource.Success ->
                    handleHomeSuccess(res.data)
            }
        }
    }


    private fun handleHomeSuccess(
        response: HomeResponse
    ) {
            produce(HomeAction.HomeData(response))

    }

    }