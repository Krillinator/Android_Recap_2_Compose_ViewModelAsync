package com.krillinator.recap_2_viewmodel_api.api

import retrofit2.Call
import retrofit2.http.GET

interface FoxApi {

    @GET("/floof")
    fun getData(): Call<Fox>

}