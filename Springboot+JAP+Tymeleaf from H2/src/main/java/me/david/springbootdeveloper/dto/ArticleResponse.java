package me.david.springbootdeveloper.dto;

import lombok.Getter;
import me.david.springbootdeveloper.domain.Article;

//응답을 위한 DTO (객체)
@Getter
public class ArticleResponse {

    //field _ the Getter takes this fields.
    private final String title;
    private final String content;

    //constructor
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
