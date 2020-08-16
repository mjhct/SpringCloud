package mjhct.springcloud.provider.controller;

import mjhct.springcloud.provider.service.ProvierServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private ProvierServiceImpl provierService;

    @GetMapping(value = "/hystrix/ok/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String okTest(@PathVariable("id") Integer id){
        return provierService.providerOk(id);
    }

    @GetMapping(value = "/hystrix/timeout/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String timeoutTest(@PathVariable("id") Integer id){
        return provierService.providerTimeOut(id);
    }

}
