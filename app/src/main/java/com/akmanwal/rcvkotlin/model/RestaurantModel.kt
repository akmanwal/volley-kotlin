package com.akmanwal.rcvkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RestaurantModel {

    @SerializedName("restaurants")
    @Expose
    var restaurants: List<Restaurant>? = null

}
