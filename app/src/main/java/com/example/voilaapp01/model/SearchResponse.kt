package com.example.voilaapp01.model

data class SearchResponse (
    val success:Boolean,
   val guides: GuideSearchFilter,
    val deals :DealerResults

)
