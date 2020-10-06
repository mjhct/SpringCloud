package mjhct.springcloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import mjhct.springcloud.sentinel.myhandler.CustomerBlockHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelServiceController {

    private static final Logger logger = LoggerFactory.getLogger(SentinelServiceController.class);

    @GetMapping(value = "/test")
    public CommonResult test() {
        logger.info("test");
        return new CommonResult(CommonCode.SUCCESS);
    }

    @GetMapping(value = "/hello")
    @SentinelResource(value = "hello",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handle1")
    public CommonResult hello() {
        logger.info("hello");
//        int age = 10 / 0; 测试异常导服务降级
        return new CommonResult(CommonCode.SUCCESS, "hello");
    }

    @GetMapping(value = "/hk")
    @SentinelResource(value = "hk", blockHandler = "handleHK")
    public CommonResult hk(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        logger.info("test");
        return new CommonResult(CommonCode.SUCCESS);
    }

    public CommonResult handleHK(String p1, String p2, BlockException blockException) {
        return new CommonResult(CommonCode.FAIL, "热点key请求过多");
    }

}
