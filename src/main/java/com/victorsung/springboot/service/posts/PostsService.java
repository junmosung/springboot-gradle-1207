package com.victorsung.springboot.service.posts;

import com.victorsung.springboot.domain.posts.PostsRepository;
import com.victorsung.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by victorsung.
 * Date: 2019/12/13
 * Time: 10:50 오전
 */
@RequiredArgsConstructor
@Service
public class PostsService {
    // @Autowired 보다 생성자를 이용하여 DI하는 것이 springboot에 덜 종속적이다.
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
