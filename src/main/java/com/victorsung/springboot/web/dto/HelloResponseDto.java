package com.victorsung.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by victorsung.
 * Date: 2019/12/07
 * Time: 4:31 오후
 */
@Getter
@RequiredArgsConstructor    // 선언된 모든 final 필드가 포함된 생성자를 생성해 준다. final이 없으면 생성자에 포함되지 않는다.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
