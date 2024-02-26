package com.mario.jwttokens.repository

import com.mario.jwttokens.model.Article
import org.springframework.stereotype.Repository

@Repository
class ArticleRepository {
    private val articles = listOf(
        Article(id = 1, title = "article 1", content = "article 1 content"),
        Article(id = 2, title = "article 2", content = "article 2 content"),
        Article(id = 3, title = "article 3", content = "article 3 content"),
    )

    fun findAll(): List<Article> {
        return articles
    }
}