package mjhct.springcloud.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import mjhct.springcloud.commons.entity.CommonCode;
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
    // 文档https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
//    @SentinelResource(value = "consumerData", fallback = "getDataFallBack")
//    @SentinelResource(value = "consumerData", blockHandler = "getDataBlockHandler")
    @SentinelResource(value = "consumerData",
            fallback = "getDataFallBack",
            blockHandler = "getDataBlockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult getData(@PathVariable(value = "id") Integer id) {
        logger.info("消费者");
        if (id > 10) {
            throw new IllegalArgumentException("非法参数错误");
        } else if (id > 5) {
            throw new NullPointerException("数据不存在错误");
        }
        return restTemplate.getForObject(PROVIDER_URL + "/provider/data/" + id, CommonResult.class);
    }

    public CommonResult getDataFallBack(Integer id, Throwable e) {
        logger.info("微服务异常，降级熔断处理");
        return new CommonResult(CommonCode.FAIL, "fallback:" + e.getMessage());
    }

    public CommonResult getDataBlockHandler(Integer id, BlockException blockException) {
        logger.info("sentinel限流处理");
        return new CommonResult(CommonCode.FAIL, "blockHandler:" + blockException.getMessage());
    }

}
