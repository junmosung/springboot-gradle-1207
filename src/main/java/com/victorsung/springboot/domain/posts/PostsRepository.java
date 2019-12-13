package com.victorsung.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by victorsung.
 * Date: 2019/12/13
 * Time: 10:15 오전
 */
// Posts 클래스로 Database를 접근하기 위해 생성한 Repository
// 보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이다. JPA에선 Repository라고 부르며 인터페이스로 생성한다. JpaRepository<Entity 클래스, PJ 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생선된다.
public interface PostsRepository extends JpaRepository<Posts,Long>{

}
