package com.example.voilaapp01.model

import com.example.voilaapp01.tourist


// tells in what format does the app expects the API to return the response data

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String,
    val interests: Boolean,
    val languages: Boolean,
    val occupied: String
)


