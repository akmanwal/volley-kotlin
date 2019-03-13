package com.akmanwal.rcvkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {

    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("formattedPhone")
    @Expose
    var formattedPhone: String? = null
    @SerializedName("twitter")
    @Expose
    var twitter: String? = null

}
