package com.webtradingportal.web;

import com.webtradingportal.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1번
public class HelloController {

    @GetMapping("/hello")
    public String hello() { // 2번
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name
                                    , @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name, amount);

    }
}
