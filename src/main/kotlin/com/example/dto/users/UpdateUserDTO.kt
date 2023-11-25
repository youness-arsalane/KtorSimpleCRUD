package example.dto.users

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserDTO(
    val email: String,
    val firstName: String,
    val lastName: String
)