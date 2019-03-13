package com.akmanwal.rcvkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.akmanwal.rcvkotlin.model.Restaurant
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val url: String = "http://sandbox.bottlerocketapps.com/BR_iOS_CodingExam_2015_Server/restaurants.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

    }

    fun getData() {
        val arrayList = ArrayList<Restaurant>()
        val requestQueue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.POST, url,
            Response.Listener<String> {
                response ->
                Log.e("response", response)

                val strResponse = response.toString()
                val jsonObject = JSONObject(strResponse)
                val jsonArray = jsonObject.getJSONArray("restaurants")

                for(i in 0 until jsonArray.length()){

                    val newJsonObject: JSONObject = jsonArray.getJSONObject(i)
                    val strName = newJsonObject.getString("name")
                    val strUrl = newJsonObject.getString("backgroundImageURL")

                    val restaurant = Restaurant()
                    restaurant.name = strName
                    restaurant.backgroundImageURL = strUrl
                    arrayList.add(restaurant)
                }

                rcv.layoutManager = LinearLayoutManager(this)
                rcv.adapter = MyAdapter(arrayList, this)


            }, Response.ErrorListener {

                Toast.makeText(applicationContext, "Error...", Toast.LENGTH_SHORT).show()
            })

        requestQueue.add(stringRequest)
        stringRequest.retryPolicy = DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.setShouldCache(false)
        requestQueue.cache.clear()
    }
}
