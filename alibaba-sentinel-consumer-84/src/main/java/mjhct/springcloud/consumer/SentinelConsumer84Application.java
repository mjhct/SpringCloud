package mjhct.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelConsumer84Application {

    public static void main(String[] args) {
        SpringApplication.run(SentinelConsumer84Application.class, args);
    }

}
