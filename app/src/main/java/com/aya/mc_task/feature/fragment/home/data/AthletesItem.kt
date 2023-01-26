package com.aya.mc_task.feature.fragment.home.data

import com.aya.mc_task.base.BasePaginationParcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AthletesItem (
    @field:SerializedName("id")
    val id: Int ,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("image")
    val image: String? = null,
    @field:SerializedName("brief")
    val brief: String? = null,

    override var viewType: Int

): BasePaginationParcelable {
    override fun unique(): Any = id
}
