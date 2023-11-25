package example.routes.users

import example.dto.users.CreateUserDTO
import example.dto.users.UpdateUserDTO
import example.repositories.users.UsersRepositoryImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Route.userRoutes() {
    val usersRepository = UsersRepositoryImpl()

    route("/users") {
        get {
            val users = usersRepository.allUsers()
            call.respond(users)
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw Exception("Wrong format")
            val user = usersRepository.getUserById(id)
            user.let { call.respond(it) }
        }

        post {
            val createUserDTO = call.receive<CreateUserDTO>()
            val user = usersRepository.createUser(createUserDTO)
            call.respondText(Json.encodeToString(user), status = HttpStatusCode.Created)
        }

        put("/{id}") {
            val updateUserDTO = call.receive<UpdateUserDTO>()
            val id = call.parameters["id"]?.toInt() ?: throw Exception("Wrong format")

            usersRepository.updateUser(id, updateUserDTO)
            val updatedUser = usersRepository.getUserById(id)
            call.respond(updatedUser)
        }

        delete("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw Exception("Wrong format")
            call.respond(usersRepository.deleteUser(id))
        }
    }
}
