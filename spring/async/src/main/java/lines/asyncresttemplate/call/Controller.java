package lines.asyncresttemplate.call;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestClientException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    final AsyncRestTemplate asyncRestTemplate;

    @GetMapping("/call/test")
    public String call(){

        try{
            asyncRestTemplate.postForEntity("call", null, String.class);
        }catch (RestClientException exception){
            log.error(exception.getMessage());
        }catch (Exception exception){
            log.error(exception.getMessage());
        }

        return "helloWorld";
    }
}
