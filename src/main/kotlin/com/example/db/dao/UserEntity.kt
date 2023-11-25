package example.db.dao

import example.db.tables.UsersTable
import example.dto.users.UserDTO
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserEntity>(UsersTable)

    var email by UsersTable.email
    var firstName by UsersTable.firstName
    var lastName by UsersTable.lastName
}

fun UserEntity.toUserDTO() = UserDTO(
    this.id.value,
    this.email,
    this.firstName,
    this.lastName
)