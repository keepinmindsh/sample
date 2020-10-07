package lines.client;

import lines.model.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class QueueTests {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        RequestVO requestVO = new RequestVO();

        requestVO.setParameterKey("19283746");

        ResponseEntity<String> responseJson1 =  restTemplate.postForEntity("http://localhost:8080/addQueue", requestVO , String.class );

        log.info(responseJson1.toString());

        requestVO.setParameterKey("19283746");

        ResponseEntity<String> responseJson2 =  restTemplate.getForEntity("http://localhost:8080/getQueue/" +  requestVO.getParameterKey() , String.class , requestVO.getParameterKey() );

        log.info("Response Date : {}", responseJson2);
    }
}
