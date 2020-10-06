package mjhct.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient6012Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient6012Application.class, args);
    }

}
