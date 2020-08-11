package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Value("${server.port}")
    private String serverPort;

    private static final String PROVIDER_SERVICE_URL = "http://provider-service";

    @Resource
    private RestTemplate restTemplate;

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

}
