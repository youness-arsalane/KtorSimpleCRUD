package example.dto.users

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserDTO(
    val email: String,
    val firstName: String,
    val lastName: String
)
