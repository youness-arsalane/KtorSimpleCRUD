package example.repositories.users

import example.dto.users.CreateUserDTO
import example.dto.users.UpdateUserDTO
import example.dto.users.UserDTO
import example.dto.users.UserId

interface UsersRepository {
    suspend fun allUsers(): List<UserDTO>
    suspend fun getUserById(userId: UserId): UserDTO
    suspend fun createUser(user: CreateUserDTO): UserDTO
    suspend fun updateUser(userId: UserId, user: UpdateUserDTO)
    suspend fun deleteUser(userId: UserId)

}