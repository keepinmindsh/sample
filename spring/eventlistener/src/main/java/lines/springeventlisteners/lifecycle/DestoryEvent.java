package lines.springeventlisteners.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DestoryEvent {

    @PostConstruct
    public void init(){
        System.out.println("초기화 메소드!!");
    }

    //소멸 메소드
    @PreDestroy
    public void destory(){
        System.out.println("종료 직전!!");
    }
}
