package com.johnowl.sleuthretrofitproducer

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class Controller {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/producer/users")
    fun getUsers(): List<User> {

        log.info("Get all users")

        return listOf(User("John"), User("Mary"), User("Peter"))
    }

}