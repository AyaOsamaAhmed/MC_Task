package com.aya.mc_task.core.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

//Binding View (Activity - Fragment) on the fly
//usually used in base Fragment/Activity
@Suppress("UNCHECKED_CAST")
fun <B : ViewDataBinding> LifecycleOwner.bindView(container: ViewGroup? = null): B {
    return if (this is Activity) {
        val inflateMethod = getTClass<B>().getMethod("inflate", LayoutInflater::class.java)
        val invokeLayout = inflateMethod.invoke(null, this.layoutInflater) as B
        this.setContentView(invokeLayout.root)
        invokeLayout
    } else {
        val fragment = this as Fragment
        val inflateMethod = getTClass<B>().getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Cannot access view bindings. View lifecycle is ${lifecycle.currentState}!")
        }
        val invoke: B = inflateMethod.invoke(null, layoutInflater, container, false) as B
        invoke
    }
}
