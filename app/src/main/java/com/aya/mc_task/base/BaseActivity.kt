package com.aya.mc_task.base

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.aya.mc_task.core.extension.bindView

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    val baseShowProgress = ObservableBoolean()
    protected abstract val mViewModel: VM
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView()
     //   binding.setVariable(BR.viewModel, mViewModel)
    }

    fun setOpacityBackground(view: View, @ColorRes color: Int) {
        view.setBackgroundColor(
            try {
                ContextCompat.getColor(this, color)
            } catch (e: Resources.NotFoundException) {
                0
            }
        )
    }

}
