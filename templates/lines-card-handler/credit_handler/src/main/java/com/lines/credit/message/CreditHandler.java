package com.lines.credit.message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditHandler {

    @GetMapping("/hello")
    public String hello() {
        return "myFunc(12342342134)";
    }
}
