package com.aya.mc_task.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.aya.mc_task.R

@BindingAdapter("app:bindImgUrl", "app:bindProgressItem")
    fun setGlideImageUrl(image: ImageView, url: String?, progressBar: ProgressBar?) {

        if(url.isNullOrBlank()){
            image.setImageResource(R.drawable.ic_launcher_background)
            progressBar?.visibility = View.GONE
            }
            else
       Glide.with(image.context)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar?.visibility = View.GONE
                    image.setImageResource(R.mipmap.ic_launcher)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }


            })
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(image)

    }

