package com.victorsung.springboot.web;

import com.victorsung.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by victorsung.
 * Date: 2019/12/07
 * Time: 4:02 오후
 */
@RestController //JSON을 반환하는 Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto hello(@RequestParam("name") String name, @RequestParam("amount")int amount){
        return new HelloResponseDto(name, amount);
    }
}
