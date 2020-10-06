package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.commons.entity.CommonResult;
import mjhct.springcloud.consumer.service.ProviderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/openfeign")
public class ConsumerController {

    @Resource
    private ProviderService providerService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult test(){
        return providerService.test();
    }

    @GetMapping(value = "/timeout", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult timeOut(){
        return providerService.timeOut();
    }

}
