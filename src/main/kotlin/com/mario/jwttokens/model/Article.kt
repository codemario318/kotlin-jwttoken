package com.mario.jwttokens.model

import java.util.UUID

data class Article(
    val id: UUID,
    val title: String,
    val content: String,
)
