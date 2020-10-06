package mjhct.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOpenFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeign80Application.class, args);
    }

}
