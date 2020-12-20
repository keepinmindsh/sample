package lines.loaded;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/example-page")
    public String index() {
        return "Hello World!1111111";
    }
}
