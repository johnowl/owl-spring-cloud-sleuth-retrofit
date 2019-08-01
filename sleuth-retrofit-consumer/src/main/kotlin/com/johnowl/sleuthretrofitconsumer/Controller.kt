package com.johnowl.sleuthretrofitconsumer

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val service: Service) {

    @GetMapping("/consumer/users")
    fun getUsers() = service.getAllUsers()

}