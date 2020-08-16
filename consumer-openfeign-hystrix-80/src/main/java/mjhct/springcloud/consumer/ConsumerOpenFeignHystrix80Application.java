package mjhct.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableHystrix：官方文档没找到，视频里演示用的这个；
 * EnableCircuitBreaker：服务侧用的这个，我猜消费侧用这个也行，确实是。
 */
@SpringBootApplication
@EnableFeignClients
//@EnableHystrix
@EnableCircuitBreaker
public class ConsumerOpenFeignHystrix80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignHystrix80Application.class, args);
    }

}
