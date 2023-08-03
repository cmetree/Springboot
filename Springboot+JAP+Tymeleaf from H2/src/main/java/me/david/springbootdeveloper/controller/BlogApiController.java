package me.david.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.domain.Article;
import me.david.springbootdeveloper.dto.AddArticleRequest;
import me.david.springbootdeveloper.dto.ArticleResponse;
import me.david.springbootdeveloper.dto.UpdateArticleRequest;
import me.david.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


//URL에 매핑하기 위한 컨트롤러 메서드를 추가 _컨트롤러 메서드는 HTTP메서드에 대응함 
@RequiredArgsConstructor
@RestController // HTTP Response Body에 *객체 데이터*를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles") // HTTP 메서드가 POST일 떄 전달받은 URL과 동일하면, 메서드로 매핑
    //요청 본문 값 매핑                                                                    //현재 인증정보를 가져오는 객체를 파라미터로 추가
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal ){
                                            //HTTP를 요청할 때, 응답에 해당하는 값을, @RequestBody 애너테이션이 붙은 대상 객체에 매핑
                                            //EX) _ post 요청으로 json형식을 뛴, AddArticleRequest의 매개변수인 title과 content를 준다.

        Article savedArticle = blogService.save(request,principal.getName());
                                                        //인증 객체에서 유저 이름을 가져온 뒤 save()메서드로 넘겨준다.
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
                                    //응답코드 201_created 를 응답하고, 테이블에 저장된 객체를 반환

    }


    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll() //
                .stream()
                .map(ArticleResponse::new)
                .toList();
        // findAll()메서드를 호출한 다음 , 응답용 객체인 ArticleResponse로 파싱해, body에 담아 클라이언트에게 전송
        // :: _ 반복자. _ Article 객체들을 ArticleResponse객체로 반드는 반복 람다 식  (객체::사용할 메서드)

        return ResponseEntity.ok().body(articles);  //article은 ArticleResponse를 가진 리스트
    }

    @GetMapping("/api/articles/{id}")
    //url 경로에서 값 출력
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build(); // 상태코드만 반환
    }


    @PutMapping("/api/articles/{id}")                                      //HTTP 요청 바디를 자바객체로 변환
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        Article updateArticle = blogService.update(id,request);

        return ResponseEntity.ok().body(updateArticle);
    }


}
