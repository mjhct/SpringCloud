package mjhct.springcloud.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl {

    private final int sleepTime = 5000;

    public String providerOk(Integer id){
        return "秒回服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

    @HystrixCommand(fallbackMethod = "providerTimeOutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String providerTimeOut(Integer id){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "复杂服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

    public String providerTimeOutHandler(Integer id){
        return "兜底服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

}
