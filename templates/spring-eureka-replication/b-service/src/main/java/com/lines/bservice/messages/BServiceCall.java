package com.lines.bservice.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BServiceCall {

    @GetMapping("/call/test")
    public Object getTest(){
        return "test2";
    }
}
