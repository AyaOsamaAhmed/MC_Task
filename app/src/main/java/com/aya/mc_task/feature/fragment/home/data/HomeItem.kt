package com.aya.mc_task.feature.fragment.home.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class HomeItem(

    @field:SerializedName("athletes")
    var athletes: List<AthletesItem>? = null,


    ) : Parcelable