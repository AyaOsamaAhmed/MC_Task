package com.aya.mc_task.feature.fragment.home.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class AthletesResponse(

    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("image")
    val image: String? = null,
    @field:SerializedName("brief")
    val brief: String? = null,


    ) : Parcelable