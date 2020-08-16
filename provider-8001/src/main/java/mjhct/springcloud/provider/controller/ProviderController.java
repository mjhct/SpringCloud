package mjhct.springcloud.provider.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProviderController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult test(){
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

    /**
     * APPLICATION_JSON_UTF8_VALUE被废弃的是因为主流浏览器已经符合规范正确解释UTF-8编码了，所以没必要带上Charset了；
     * 但是，我用JMeter测试，并不能正确解释中文，所以还是带上吧。
     * @return
     */
    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult testPost(){
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

    @GetMapping(value = "/discovery", produces = MediaType.APPLICATION_JSON_VALUE)
    public void discoveryClient(){
        List<String> services = discoveryClient.getServices();
        logger.info("services:" + services);

        for (String service : services){
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            logger.info(service + " have instances:" + instances);
        }
    }

}
