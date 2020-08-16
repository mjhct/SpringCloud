package mjhct.springcloud.consumer.controller;

import mjhct.springcloud.consumer.service.ProviderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private ProviderService providerService;

    @GetMapping(value = "/hystrix/ok/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String okTest(@PathVariable("id") Integer id){
        return providerService.providerOk(id);
    }

    @GetMapping(value = "/hystrix/timeout/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String timeoutTest(@PathVariable("id") Integer id){
        return providerService.providerTimeout(id);
    }

}
