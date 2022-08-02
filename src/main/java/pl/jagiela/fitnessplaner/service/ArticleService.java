package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.Article;
import pl.jagiela.fitnessplaner.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article addNewArticle(Article article) {
        article.setDate(LocalDate.now());
        return articleRepository.save(article);
    }

    public List<Article> getArticlesList() {
        List<Article> articlesList = articleRepository.findAll();
        return articleRepository.findAll();
    }

    public void deleteArticleById(Long id) {
        Article article = articleRepository.getById(id);
        articleRepository.deleteById(id);
    }

    public List<Article> findByIdOwner(Long idOwner) {
        List<Article> articlesList = articleRepository.findByIdOwner(idOwner);
        return articlesList;
    }

    public Article getArticleById(Long id) {
        Article article = articleRepository.getById(id);
        return article;
    }

}
