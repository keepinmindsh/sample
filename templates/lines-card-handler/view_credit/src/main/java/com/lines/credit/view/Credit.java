package com.lines.credit.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Credit {

    @GetMapping("/credit")
    public String credit(){
        return "credit";
    }
}
