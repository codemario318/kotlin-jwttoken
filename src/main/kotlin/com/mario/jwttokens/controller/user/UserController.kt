package com.mario.jwttokens.controller.user

import com.mario.jwttokens.model.Role
import com.mario.jwttokens.model.User
import com.mario.jwttokens.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): UserResponse {
        return userService.createUser(
            user = userRequest.toModel()
        ) ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "회원가입에 실패하였습니다.")
    }

    @GetMapping
    fun listAll(): List<UserResponse> {
        return userService.findAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): UserResponse {
        return userService.findById(id)
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "회원 정보를 찾을 수 없습니다.")

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Boolean> {
        val success = userService.deleteById(id)

        return if (success)
            ResponseEntity.noContent().build()
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "회원 탈퇴에 실패하였습니다.")
    }

    private fun UserRequest.toModel(): User {
        return User(
            id = UUID.randomUUID(),
            email = this.email,
            password = this.password,
            role = Role.USER
        )
    }

    private fun User.toResponse(): UserResponse {
        return UserResponse(
            id = this.id,
            email = this.email
        )
    }
}