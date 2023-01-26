package  com.aya.mc_task.core.network

import com.aya.mc_task.core.response.ErrorResponse
import com.aya.mc_task.core.response.NetworkResponse
import com.aya.mc_task.feature.fragment.home.data.HomeResponse
import retrofit2.http.GET

interface MainApis {

    companion object {
        private const val MAIN = "Bassem-Samy/f227855df4d197d3737c304e9377c4d4/raw/ece2a30b16a77ee58091886bf6d3445946e10a23/"

        }

    @GET(MAIN)
    suspend fun getData(): NetworkResponse<HomeResponse, ErrorResponse>


}