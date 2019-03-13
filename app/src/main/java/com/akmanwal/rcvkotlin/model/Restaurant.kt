package com.akmanwal.rcvkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Restaurant {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("backgroundImageURL")
    @Expose
    var backgroundImageURL: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null

    @SerializedName("contact")
    @Expose
    var contact: Contact? = null

    @SerializedName("location")
    @Expose
    var location: Location? = null

}
