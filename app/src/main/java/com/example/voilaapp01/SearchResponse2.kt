package com.example.voilaapp01

data class SearchResponse2(
    var  guides: List<Guide>,
    var deals: List<Deal>,
    var success: Boolean
)