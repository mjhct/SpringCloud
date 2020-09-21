package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.commons.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Value("${server-url.provider-service}")
    private String providerServiceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public CommonResult test() {
        return restTemplate.getForObject(providerServiceUrl + "/provider/test", CommonResult.class);
    }

}
