package mjhct.springcloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import mjhct.springcloud.consumer.service.ProviderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalFallBackMethod")
public class ConsumerController {

    @Resource
    private ProviderService providerService;

    @GetMapping(value = "/hystrix/ok/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String okTest(@PathVariable("id") Integer id){
        return providerService.providerOk(id);
    }

    @GetMapping(value = "/hystrix/timeout/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @HystrixCommand(fallbackMethod = "timeoutTestHandler",commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String timeoutTest(@PathVariable("id") Integer id){
        // int i = 10 / 0;
        return providerService.providerTimeout(id);
    }

    public String timeoutTestHandler(Integer id){
        return "兜底服务:" + Thread.currentThread().getName() + ",对方系统服务繁忙或80运行出错,id=" + id;
    }

    /**
     * 全局服务降级处理方法
     * @return
     */
    public String globalFallBackMethod(){
        return "全局兜底服务:" + Thread.currentThread().getName();
    }

}
