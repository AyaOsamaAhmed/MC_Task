package com.aya.mc_task.feature.fragment.home.domain

import com.aya.mc_task.feature.fragment.home.data.AthletesItem
import com.aya.mc_task.feature.fragment.home.data.HomeItem
import com.aya.mc_task.feature.fragment.home.data.HomeResponse

object HomeMapper {

    fun mapData(res: HomeResponse): HomeItem {
        val result = HomeItem()


        result.athletes = List<AthletesItem>(res.athletes!!.size){
            AthletesItem(it , res.athletes[it].name , res.athletes[it].image , res.athletes[it].brief , it)
        }
        return result
    }

}