package com.mario.jwttokens.repository

import com.mario.jwttokens.model.Role
import com.mario.jwttokens.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            email = "user1@gmail.com",
            password = "password",
            role = Role.USER
        ),
        User(
            id = UUID.randomUUID(),
            email = "user2@gmail.com",
            password = "password",
            role = Role.ADMIN
        ),
        User(
            id = UUID.randomUUID(),
            email = "user3@gmail.com",
            password = "password",
            role = Role.USER
        )
    )

    fun save(user: User): Boolean {
        return users.add(user)
    }

    fun findByEmail(email: String): User? {
        return users.firstOrNull { it.email == email }
    }

    fun findById(id: UUID): User? {
        return users.firstOrNull { it.id == id }
    }

    fun deleteById(id: UUID): Boolean {
        val foundUser = findById(id)

        return foundUser?.let {
            users.remove(it)
        } ?: false
    }

    fun findAll(): List<User> {
        return users
    }
}