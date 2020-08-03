package com.example.voilaapp01

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object Factory {
        fun create(): Api {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://voila2020.herokuapp.com")
                .build()

            return retrofit.create(Api::class.java)
        }
    }

}

