package lines.reactive.sample.parent;

import lines.reactive.sample.child1.Ctx1Config;
import lines.reactive.sample.child2.Ctx2Config;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(ServiceConfig.class)
                .web(WebApplicationType.NONE)
                .child(Ctx1Config.class)
                .web(WebApplicationType.SERVLET)
                .sibling(Ctx2Config.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
