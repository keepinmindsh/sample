package lines.sample.child2;

import lines.sample.parent.IHomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ctx2Controller {

    final IHomeService homeService;

    public Ctx2Controller(IHomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return homeService.getGreeting();
    }
}
