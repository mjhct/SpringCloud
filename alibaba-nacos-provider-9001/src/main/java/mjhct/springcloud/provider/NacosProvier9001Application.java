package mjhct.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvier9001Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvier9001Application.class, args);
    }

}
