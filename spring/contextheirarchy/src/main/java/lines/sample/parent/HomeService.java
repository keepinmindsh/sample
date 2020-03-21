package lines.sample.parent;

import org.springframework.stereotype.Service;

@Service
public class HomeService implements  IHomeService {
    @Override
    public String getGreeting() {
        return "Welcome User!";
    }
}
