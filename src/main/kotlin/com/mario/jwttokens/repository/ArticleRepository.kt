package com.mario.jwttokens.repository

import com.mario.jwttokens.model.Article
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ArticleRepository {
    private val articles = listOf(
        Article(id = UUID.randomUUID(), title = "article 1", content = "article 1 content"),
        Article(id = UUID.randomUUID(), title = "article 2", content = "article 2 content"),
        Article(id = UUID.randomUUID(), title = "article 3", content = "article 3 content"),
    )

    fun findAll(): List<Article> {
        return articles
    }
}