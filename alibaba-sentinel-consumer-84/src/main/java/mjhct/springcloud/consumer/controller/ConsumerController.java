package mjhct.springcloud.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import mjhct.springcloud.commons.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    private final String PROVIDER_URL="http://nacos-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/data/{id}")
    public CommonResult getData(@PathVariable(value = "id") Integer id) {
        logger.info("消费者");
        if (id > 10) {
            throw new IllegalArgumentException("非法参数错误");
        } else if (id > 5) {
            throw new NullPointerException("数据不存在错误");
        }
        return restTemplate.getForObject(PROVIDER_URL + "/provider/data/" + id, CommonResult.class);
    }
}
