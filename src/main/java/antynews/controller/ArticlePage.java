package antynews.controller;

import antynews.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Article Page", value = "/article/*")
public class ArticlePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ArticleRepository articleRepository = ArticleRepository.getInstance();

        String pathNumberString = req.getPathInfo().substring(1);
        List<Article> articleList = articleRepository.getAllArticles();

        if (pathNumberString.chars().allMatch(Character::isDigit)){
            Integer pathNumber = Integer.parseInt(pathNumberString);
            for(Article article : articleList){
                if(pathNumber == article.getId()){
                    req.setAttribute("article", article);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/antynews/ArticlePage.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            // Jak nie znajdzie artykułu
            RedirectToErrorPage(req, resp);
        } else {
            RedirectToErrorPage(req, resp);
        }




    }

    private void RedirectToErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error", "Podany artykuł nie istnieje");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/antynews/Error.jsp");
        dispatcher.forward(req, resp);

    }
}
