package com.example.voilaapp01

import com.example.voilaapp01.model.*
import retrofit2.Call

import retrofit2.http.*

interface Api {


    @POST("/login/tourist")

    fun login(
        @Body userLogin: UserLogin
    ): Call<LoginResponse>



    @POST("/searchGuidesAndDeals")
    fun search(
        @Body searchFilter2: SearchFilter2
    ):Call<SearchResponse2>


    @POST("/signup/tourist")
    fun signup(
        @Body userSignup: UserSignup
    ):Call<SignupResponse>

}