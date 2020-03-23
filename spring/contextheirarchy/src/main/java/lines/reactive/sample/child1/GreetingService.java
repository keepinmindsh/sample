package lines.reactive.sample.child1;

import lines.reactive.sample.parent.IHomeService;

public class GreetingService implements IHomeService {
    @Override
    public String getGreeting() {
        return "Greeting A";
    }
}
