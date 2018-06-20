package antynews.controller;

import antynews.model.Article;
import antynews.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ArticleRepository {

    private static ArticleRepository instance = null;

    protected ArticleRepository() {}

    public static ArticleRepository getInstance() {
        if (instance == null) {
            instance = new ArticleRepository();
        }
        return instance;
    }

    public Article findArticleById(long id) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return entityManager.find(Article.class, id);
    }

    public List<Article> getAllArticles() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
        Root<Article> from = criteria.from(Article.class);
        criteria.select(from);
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<Article> findArticleByExactString(String value) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
        Root<Article> from = criteria.from(Article.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("tittle"), value));
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<Article> findArticleByPartialString(String value) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
        Root<Article> from = criteria.from(Article.class);
        criteria.select(from);
        criteria.where(builder.like(from.<String>get("tittle"), "%" + value + "%"));
        return entityManager.createQuery(criteria).getResultList();
    }



    public Article saveArticle(Article article) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        if (article.getId() == 0) {
            entityManager.persist(article);
        } else {
            entityManager.merge(article);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return article;
    }

    public Category saveCategory(Category category) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        if (category.getId() == 0) {
            entityManager.persist(category);
        } else {
            entityManager.merge(category);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return category;
    }



}
