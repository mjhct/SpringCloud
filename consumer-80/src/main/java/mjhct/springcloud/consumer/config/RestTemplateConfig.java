package mjhct.springcloud.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private RestTemplate restTemplate = new RestTemplate();

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return this.restTemplate;
    }

}
