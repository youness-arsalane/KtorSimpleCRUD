package example.dto.users

import kotlinx.serialization.Serializable

typealias UserId = Int

@Serializable
data class UserDTO(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String
)
