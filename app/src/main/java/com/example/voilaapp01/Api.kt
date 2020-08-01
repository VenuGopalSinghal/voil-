package com.example.voilaapp01

import com.example.voilaapp01.model.*
import retrofit2.Call

import retrofit2.http.*

interface Api {

    @POST("/login/tourist")

    fun login(
        @Body user: User
    ): Call<LoginResponse>



    @POST("/tourist/guides")
    fun search(
        @Body searchFilter: Searchfilter
    ):Call<SearchResponse>

}