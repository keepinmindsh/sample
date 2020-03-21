package lines.sample.child1;

import lines.sample.parent.IHomeService;

public class GreetingService implements IHomeService {
    @Override
    public String getGreeting() {
        return "Greeting A";
    }
}
