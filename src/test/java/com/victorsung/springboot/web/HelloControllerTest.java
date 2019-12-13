package com.victorsung.springboot.web;

import com.victorsung.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by victorsung.
 * Date: 2019/12/07
 * Time: 4:05 오후
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    MockMvc mvc;    // web API를 test할때 사용한다.

    @Test
    public void testGet() throws Exception {
        String string = "hello";

        mvc.perform(get("/hello"))  // get 요청
                .andExpect(status().isOk())     // perform의 결과를 검증
               .andExpect(content().string(string));
    }

    @Test 
    public void testLombok() throws Exception {
    	// given 
        String name = "victorsung";
        int amount = 100;
    	// when
        HelloResponseDto dto = new HelloResponseDto(name,amount);
        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

    @Test
    public void getGetDto() throws Exception {
        String name = "victorsung";
        int amount = 100;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}