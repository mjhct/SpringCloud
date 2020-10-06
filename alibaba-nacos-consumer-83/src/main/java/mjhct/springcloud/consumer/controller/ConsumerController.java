package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class ConsumerController {

    @Value("${server-url.provider-service}")
    private String providerServiceUrl;

    @Resource
    private RestTemplate restTemplate;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/test")
    public CommonResult test() {
        return restTemplate.getForObject(providerServiceUrl + "/provider/test", CommonResult.class);
    }

    @GetMapping("/config/info")
    public CommonResult<String> getConfigInfo() {
        return new CommonResult<>(CommonCode.SUCCESS, configInfo);
    }

}
