package com.victorsung.springboot.web;

import com.victorsung.springboot.service.posts.PostsService;
import com.victorsung.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by victorsung.
 * Date: 2019/12/13
 * Time: 10:49 오전
 */
@RequiredArgsConstructor    // final이 선언된 모든 필드를 인자값으로 하는 생성자를 Lombok이 만들어준다.
@RestController
public class PostsController {

    private final PostsService postsService;

    @PutMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
