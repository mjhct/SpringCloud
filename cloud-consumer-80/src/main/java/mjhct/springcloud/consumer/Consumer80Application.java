package mjhct.springcloud.consumer;

import mjhct.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "provider-service", configuration = MySelfRule.class)
public class Consumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer80Application.class, args);
    }

}
