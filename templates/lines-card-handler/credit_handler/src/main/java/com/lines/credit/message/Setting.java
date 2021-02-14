package com.lines.credit.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Setting {

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping("/elements")
    public String elements() {
        return "elements.html";
    }

    @GetMapping("/generic")
    public String generic() {
        return "generic.html";
    }

}
