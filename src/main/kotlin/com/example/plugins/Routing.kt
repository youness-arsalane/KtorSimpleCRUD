package com.example.plugins

import example.routes.users.userRoutes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("{\"success\":\"true\"}", ContentType.Application.Json)
        }

        userRoutes()
    }
}
