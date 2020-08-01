package com.example.voilaapp01.model


data class Searchfilter(
    var state:String,
    var startDate:String,
    var endDate:String,
    var noOfPeople:Int,
    var extra_filter:Int,
    var filters :Boolean=false
)