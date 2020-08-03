package com.example.voilaapp01

data class Deal(
    var __v: Int,
    var _id: String,
    var city: String,
    var endDate: String,
    var favorites: List<Any>,
    var groupType: String,
    var guideId: GuideId,
    var peopleLeft: Int,
    var peopleLimit: Int,
    var placeCoordinates: List<PlaceCoordinate>,
    var places: List<Place>,
    var price: Int,
    var startDate: String,
    var state: String
)