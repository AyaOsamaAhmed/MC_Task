package com.aya.mc_task.core.extension


import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import timber.log.Timber
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

//get Generic Class Type
@Suppress("UNCHECKED_CAST")
fun <T : Any> Any.getTClass(): Class<T> {
    val type: Type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
    return type as Class<T>
}

fun Any?.showLogMessage(tag: String? = "MC Task") =
    Timber.let {
        if (!tag.isNullOrBlank())
            it.tag(tag)
        it.e(this.toString())
    }

fun <T> DiffUtil.ItemCallback<T>.asConfig(): AsyncDifferConfig<T> {
    return AsyncDifferConfig.Builder(this)
        .setBackgroundThreadExecutor(Dispatchers.IO.asExecutor())
        .build()
}