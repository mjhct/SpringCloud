package mjhct.springcloud.provider.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl {

    private final int sleepTime = 3000;

    public String providerOk(Integer id){
        return "秒回服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

    @HystrixCommand(fallbackMethod = "providerTimeOutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String providerTimeOut(Integer id){
        // int i = 10/0;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "复杂服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

    public String providerTimeOutHandler(Integer id){
        return "兜底服务:" + Thread.currentThread().getName() + ",8001系统服务繁忙或运行出错,id=" + id;
    }

    /**
     * 更多HystrixCommand配置查看类HystrixCommandProperties;官方文档https://github.com/Netflix/Hystrix/wiki/Configuration
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "providerCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 启用断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 窗口期请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 窗口期，毫秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 错误率，百分比
    })
    public String providerCircuitBreaker(Integer id){
        if (id == null || id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "服务调用成功，流水号:" + uuid;
    }

    /**
     * 这里没有参数居然会报错
     * @param id
     * @return
     */
    public String providerCircuitBreakerFallBack(Integer id){
        return "熔断兜底服务，线程号:" + Thread.currentThread().getName();
    }

}
