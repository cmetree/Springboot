package me.david.springbootdeveloper.dto.dto_forView;


//뷰에서 사용할 DTO

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.david.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private  String author;
    // 글 상세 페이지에서도 글쓴이의 정보가 보여야 하므로 추가.


    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.author = article.getAuthor();
    }
}
