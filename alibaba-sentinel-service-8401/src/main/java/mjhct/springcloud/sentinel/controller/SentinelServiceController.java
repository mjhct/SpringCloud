package mjhct.springcloud.sentinel.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelServiceController {

    private static final Logger logger = LoggerFactory.getLogger(SentinelServiceController.class);

    @GetMapping(value = "/test")
    public CommonResult test() {
        return new CommonResult(CommonCode.SUCCESS);
    }

}
