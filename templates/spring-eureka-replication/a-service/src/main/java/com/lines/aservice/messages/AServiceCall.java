package com.lines.aservice.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AServiceCall {

    @GetMapping("/call/test")
    public Object getTest(){
        return "test1";
    }

}
