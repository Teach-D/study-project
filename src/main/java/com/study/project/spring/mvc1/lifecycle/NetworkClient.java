package sw.contest.spring.mvc1.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @PostConstruct
    public void connect() {
        System.out.println("초기화 연결");
    }

    @PreDestroy
    public void close() {
        System.out.println("종료");
    }
}
