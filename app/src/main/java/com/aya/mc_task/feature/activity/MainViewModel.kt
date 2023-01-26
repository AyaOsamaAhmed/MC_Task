package com.aya.mc_task.feature.activity

import android.app.Application
import com.aya.mc_task.base.Action
import com.aya.mc_task.base.AndroidBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

sealed class MainAction : Action {
}

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application
) : AndroidBaseViewModel<MainAction>(app) {




}
