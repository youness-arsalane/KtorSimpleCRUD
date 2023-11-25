package example.repositories.users

import example.db.DatabaseFactory.dbQuery
import example.db.dao.UserEntity
import example.db.dao.toUserDTO
import example.dto.users.CreateUserDTO
import example.dto.users.UpdateUserDTO
import example.dto.users.UserDTO
import example.dto.users.UserId

class UsersRepositoryImpl : UsersRepository {

    override suspend fun allUsers(): List<UserDTO> = dbQuery {
        UserEntity.all().map {
            it.toUserDTO()
        }
    }

    override suspend fun getUserById(userId: UserId): UserDTO = dbQuery {
        UserEntity.findById(userId)?.toUserDTO() ?: throw Exception("User not found")
    }

    override suspend fun createUser(user: CreateUserDTO): UserDTO = dbQuery {
        UserEntity.new {
            email = user.email
            firstName = user.firstName
            lastName = user.lastName
        }.toUserDTO()
    }

    override suspend fun updateUser(userId: UserId, user: UpdateUserDTO) = dbQuery {
        UserEntity.findById(userId)?.let {
            it.email = user.email
            it.firstName = user.firstName
            it.lastName = user.lastName
        } ?: throw Exception("User not found")
    }

    override suspend fun deleteUser(userId: UserId) = dbQuery {
        UserEntity.findById(userId)?.delete() ?: throw Exception("User not found")
    }
}

val usersRepository: UsersRepository = UsersRepositoryImpl()
