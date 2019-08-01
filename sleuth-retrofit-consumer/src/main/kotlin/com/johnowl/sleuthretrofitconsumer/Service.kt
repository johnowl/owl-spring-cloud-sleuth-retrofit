package com.johnowl.sleuthretrofitconsumer

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class Service(val client: ConsumerClient) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun getAllUsers(): List<User>? {

        log.info("Getting all users")

        val call = client.getUsers()
        val response = call.execute()

        if(response.isSuccessful)
            return response.body()

        val message = "An error ocurred =/"
        log.error(message)
        throw Exception(message)
    }

}