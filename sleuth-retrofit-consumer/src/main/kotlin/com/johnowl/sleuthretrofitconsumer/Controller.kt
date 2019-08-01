package com.johnowl.sleuthretrofitconsumer

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val client: ConsumerClient) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/consumer/users")
    fun getUsers(): List<User>? {

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