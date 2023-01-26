package com.aya.mc_task.base

import android.os.Parcelable

interface BaseParcelable : Parcelable {
    fun unique(): Any
}