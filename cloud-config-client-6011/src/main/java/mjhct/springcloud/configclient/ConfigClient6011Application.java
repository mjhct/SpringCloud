package mjhct.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient6011Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient6011Application.class, args);
    }

}
