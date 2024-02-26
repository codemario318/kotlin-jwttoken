package com.mario.jwttokens.service

import com.mario.jwttokens.model.User
import com.mario.jwttokens.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(user: User): User? {
        val foundUser = userRepository.findByEmail(user.email)

        return if (foundUser == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findById(id: UUID): User? {
        return userRepository.findById(id)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun deleteById(id: UUID): Boolean {
        return userRepository.deleteById(id)
    }
}