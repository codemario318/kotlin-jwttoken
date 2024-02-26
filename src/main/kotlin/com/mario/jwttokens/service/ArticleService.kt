package com.mario.jwttokens.service

import com.mario.jwttokens.model.Article
import com.mario.jwttokens.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {
    fun findAll(): List<Article> {
        return articleRepository.findAll()
    }
}