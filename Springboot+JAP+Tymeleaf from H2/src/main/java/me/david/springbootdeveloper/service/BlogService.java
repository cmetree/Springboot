package me.david.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.domain.Article;
import me.david.springbootdeveloper.dto.AddArticleRequest;
import me.david.springbootdeveloper.dto.UpdateArticleRequest;
import me.david.springbootdeveloper.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NOTNULL이 붙은 필드의 생성자 추가,
@Service  //빈으로 등록_서블릿 컨테이너에 등록
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request,String userName){

        return blogRepository.save(request.toEntity(userName)); //AddArticleRequest의 매개변수로 author를 전달한다.
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }


    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: " +id));
    }
    //수정 및 삭제 메서드를 수행하기 전에는 맨 아래 메서드를 실행해, 현재 인증 객체에 담겨 있는 사용자의 정보와 글을 작성한 사용자의 정보를 비교하여, 확인함.
    public void delete(long id) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }


    // 게시글을 작성한 유저인지 확인
    //- 수정,삭제 메서드는 작업을 수행하기 전 authorizeArticleAuthor()메서드를 실행해 현재 객체에 담겨 있는 사용자의 정보와 글을 작성한 사용자의 정보를 비교함.
    //-만약 서로 다르다면 예외를 방생시켜 작업 수행 하지 않는다.
    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        // 같지 않다면
        if (!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("not authorized");
        }
    }


}
