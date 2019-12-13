package com.victorsung.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by victorsung.
 * Date: 2019/12/13
 * Time: 9:56 오전
 */

// Entity Class에서는 절대 Setter를 만들지 않는다. 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명화갛게 구분할 수 없기 때문이다.
// 기본적 구조는 생성자를 통해 최종값을 채운후, DB에 insert 한다. 값 변경이 필요한 경우 해당 이벤트에 맞는 public method를 호출하여 변경하는 것을 전제로 한다.
@Getter
@NoArgsConstructor  // 기본생성자 in Lombok
@Entity // table과 링크될 클래스임을 선언하는것 (SalesManager.java -> sales_manager table의 이름으로 저장된다. ) in JPA
public class Posts {
    @Id // 해당 Table의 PK 필드를 나타낸다. in JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다. in JPA
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;
    private String author;

    // 빌더를 사용하면 어느 필드에 어떤 값을 채워야 할 지 명확하게 알 수 있다.
    @Builder    // 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함한다. in Lombok
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
