package com.example.demo.controllers.api

import com.example.demo.repositories.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/articles")
class ArticleController(private val articleRepository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = articleRepository.findAllByOrderByCreatedDateDesc()

    @GetMapping("/{slug}")
    fun findBySlug(@PathVariable slug: String) =
            articleRepository.findBySlug(slug) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

}