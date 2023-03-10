package com.aya.mc_task.feature.fragment.home.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class HomeResponse(

    @field:SerializedName("athletes")
    val athletes: List<AthletesResponse>? = null,


    ) : Parcelable