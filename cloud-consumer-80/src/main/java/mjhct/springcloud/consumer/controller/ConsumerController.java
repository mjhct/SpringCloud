package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import mjhct.springcloud.consumer.lb.LoadBalance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Value("${server.port}")
    private String serverPort;

    private static final String PROVIDER_SERVICE_URL = "http://provider-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    /**
     * produces：设置响应的数据类型
     * @return
     */
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult test(){
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

    @GetMapping(value = "/provider/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult getFromProvider(){
        return restTemplate.getForObject(PROVIDER_SERVICE_URL + "/provider/test", CommonResult.class);
    }

    @GetMapping(value = "/provider/lb", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult getFromProviderLB(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("provider-service");

        if (CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }

        ServiceInstance instance = loadBalance.choose(serviceInstances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/provider/test", CommonResult.class);

    }

}
