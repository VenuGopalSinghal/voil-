package com.example.voilaapp01.model

import androidx.appcompat.widget.AppCompatEditText


data class UserSignup(
    var name: String,
    var gender: String,
    var phoneNumber: Int,
    var age: Int,
    var email: String,
    var picUrl: String,
    var nationality: String,
    var occupied: Boolean,
    var password: String
)