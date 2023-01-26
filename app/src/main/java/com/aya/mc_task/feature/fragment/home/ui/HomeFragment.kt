package com.aya.mc_task.feature.fragment.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.aya.mc_task.R
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import com.aya.mc_task.base.BaseFragment
import com.aya.mc_task.core.extension.observe
import com.aya.mc_task.databinding.HomeFragmentBinding
import com.aya.mc_task.feature.fragment.home.data.AthletesItem
import com.aya.mc_task.feature.fragment.home.ui.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(){

    private lateinit var nav : NavHostFragment
    private lateinit var navController : NavController
    override val mViewModel: HomeViewModel by viewModels()

    private val adapter = HomeAdapter(::onItemClicked)

    override fun onFragmentReady() {
        mViewModel.apply {
            observe(viewState) {
                handleViewState(it)
            }
        }
        binding.apply {
            rvUser.adapter = adapter
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nav =  activity?.supportFragmentManager?.findFragmentById(R.id.main_layout) as NavHostFragment
        navController = nav.navController

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    private fun handleViewState(action: HomeAction) {
        when (action) {
            is HomeAction.ShowLoading -> {

                showProgress(action.show)
            }
            is HomeAction.ShowFailureMsg -> showToast(action.message)
            is HomeAction.HomeData -> {
                adapter.submitList(action.data.athletes)

            }
         }
    }

    private fun onItemClicked(item: AthletesItem) {
      //  navController.navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment(item.id))
    }

}