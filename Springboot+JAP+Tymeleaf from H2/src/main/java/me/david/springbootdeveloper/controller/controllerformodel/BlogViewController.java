package me.david.springbootdeveloper.controller.controllerformodel;

import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.domain.Article;
import me.david.springbootdeveloper.dto.dto_forView.ArticleListViewResponse;
import me.david.springbootdeveloper.dto.dto_forView.ArticleViewResponse;
import me.david.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller // 사용자의 요청을 처리하고 난 후, 정해진 뷰에 객체를 넘겨주는 역활
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){  // 모델 객체는 코드처럼 인자로 선언하기만 하면, 스프링이 알아서 만들어 준다.
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles",articles);

        return "articleList"; // 해당 html라는 뷰 조회
    }

    //블로그 글을 반환할 컨트롤러의 메서드 작성
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article",new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    //id 키를 가진 쿼리 파라미터의 값을 id 변수에 매핑(id는 없을 수도 있음)
    public String newArticle(@RequestParam(required = false) Long id, Model model){

        if(id == null){
            model.addAttribute("article",new ArticleViewResponse());

        } else{
            Article article = blogService.findById(id);
            model.addAttribute("article",new ArticleViewResponse(article));
        }

        return "newArticle";

    }



}
