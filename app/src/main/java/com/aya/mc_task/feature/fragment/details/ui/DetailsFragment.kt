package com.aya.mc_task.feature.fragment.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.aya.mc_task.R
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.aya.mc_task.base.BaseFragment
import com.aya.mc_task.core.extension.observe
import com.aya.mc_task.databinding.DetailsFragmentBinding
import com.aya.mc_task.feature.fragment.home.data.AthletesItem
import com.aya.mc_task.feature.fragment.home.ui.HomeAction
import com.aya.mc_task.feature.fragment.home.ui.HomeViewModel
import com.aya.mc_task.feature.fragment.home.ui.adapter.HomeAdapter
import com.aya.mc_task.utils.setGlideImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<DetailsFragmentBinding, HomeViewModel>(){

    private lateinit var nav : NavHostFragment
    private lateinit var navController : NavController
    override val mViewModel: HomeViewModel by viewModels()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onFragmentReady() {

        val item = args.item
        binding.apply {
            setGlideImageUrl(image,item?.image,progressBar)
           binding.name.text = item?.name
            binding.desc.text = item?.brief
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


            }
         }
    }



}