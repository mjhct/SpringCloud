package mjhct.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOpenFeignHystrix80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignHystrix80Application.class, args);
    }

}
