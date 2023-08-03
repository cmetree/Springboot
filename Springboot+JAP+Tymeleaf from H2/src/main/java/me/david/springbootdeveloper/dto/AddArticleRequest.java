package me.david.springbootdeveloper.dto;


//DTO _데이터를 교환하기 위해 사용하는 객체
//-> 데이터베이스와 연결되고ㅡ 데이터를 조회하고 수정하는데 사용하는 객체,
//-> 데이서 수정과 관련된 로직이 포함되지만,BUT 단순하게 데이터를 옮기기 위해 사용하는 전달자 역활을 하는 객체 SO, 별도의 비즈니스 로직을 포함하지 않는다




//요청 본문을 받을 객체 _ AddArticleRequest


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.david.springbootdeveloper.domain.Article;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

                        // author_구글 아이디를 매개변수로 받아서, 객체에 추가한다.!
    public Article toEntity(String author){ // 생성자를 사용해, *객체 생성*
        return Article.builder()

                .title(title)
                .content(content)
                .author(author)
                .build();


    }

}
