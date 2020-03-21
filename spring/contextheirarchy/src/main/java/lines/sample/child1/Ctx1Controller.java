package lines.sample.child1;

import lines.sample.parent.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ctx1Controller {

    @Autowired
    IHomeService homeService;

    @GetMapping("/home")
    @ResponseBody
    public String greeting() {
        return homeService.getGreeting();
    }
}
