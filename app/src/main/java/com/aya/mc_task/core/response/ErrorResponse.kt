package com.aya.mc_task.core.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
open class ErrorResponse(

    @field:SerializedName("message")
    val message: String? = null,

) : Parcelable
