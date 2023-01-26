package com.aya.mc_task.feature.activity

import android.os.Bundle
import com.aya.mc_task.R
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.aya.mc_task.base.BaseActivity
import com.aya.mc_task.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() ,  NavController.OnDestinationChangedListener {

    private lateinit var nav : NavHostFragment
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nav =   supportFragmentManager.findFragmentById(R.id.main_layout) as NavHostFragment
        navController = nav.navController

    }

    override val mViewModel: MainViewModel by viewModels()


    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {

    }


}