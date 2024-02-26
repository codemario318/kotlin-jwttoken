package com.mario.jwttokens.controller.auth

data class AuthenticationRequest(
    val email: String,
    val password: String
)
