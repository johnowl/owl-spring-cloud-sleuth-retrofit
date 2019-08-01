package com.johnowl.sleuthretrofitconsumer

import retrofit2.Call
import retrofit2.http.GET

interface ConsumerClient {

    @GET("/producer/users")
    fun getUsers(): Call<List<User>>
}