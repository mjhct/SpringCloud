package mjhct.springcloud.provier.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test")
    public CommonResult test(){
        logger.info("服务提供者{}", serverPort);
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

}
