package com.example.voilaapp01.model

data class GuideSearchFilter(
    val name: String,
    val gender: String,
    val phoneNumber: Int,
    val email: String,
    val perHeadCharge: Int,
    val perDayCharge: Int,
    val picUrl: String,
    val interests: String,
    val languages: String,
    val city: String
)