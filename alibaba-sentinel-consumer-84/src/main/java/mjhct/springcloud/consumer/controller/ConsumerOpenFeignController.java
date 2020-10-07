package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.commons.entity.CommonResult;
import mjhct.springcloud.consumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/feign")
public class ConsumerOpenFeignController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerOpenFeignController.class);

    @Resource
    private ConsumerService consumerService;

    @GetMapping("/data/{id}")
    public CommonResult getData(@PathVariable(value = "id") Integer id) {
        return consumerService.getData(id);
    }

}
