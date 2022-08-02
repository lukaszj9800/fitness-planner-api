package pl.jagiela.fitnessplaner.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.Article;
import pl.jagiela.fitnessplaner.service.ArticleService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("")
    public ResponseEntity<Article> addNewArticle(@RequestBody Article article) {
        Article articleToAdd = articleService.addNewArticle(article);
        return ResponseEntity.status(HttpStatus.OK).body(articleToAdd);
    }

    @GetMapping("")
    public ResponseEntity<List<Article>> getArticlesList() {
        List<Article> articlesList = articleService.getArticlesList();
        return ResponseEntity.status(HttpStatus.OK).body(articlesList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        articleService.deleteArticleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @GetMapping("/idOwner/{idOwner}")
    public ResponseEntity<List<Article>> findByIdOwner(@PathVariable Long idOwner) {
        List<Article> articlesList = articleService.findByIdOwner(idOwner);
        return ResponseEntity.status(HttpStatus.OK).body(articlesList);
    }

    @GetMapping("/idArticle/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

}
