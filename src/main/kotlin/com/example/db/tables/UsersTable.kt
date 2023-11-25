package example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object UsersTable : IntIdTable() {
    val email = varchar("email", 255).default("")
    val firstName = varchar("firstName", 255).default("")
    val lastName = varchar("lastName", 255).default("")
}