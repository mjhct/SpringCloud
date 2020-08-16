package mjhct.springcloud.provider.service;

import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl {

    private final int sleepTime = 5000;

    public String providerOk(Integer id){
        return "秒回服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

    public String providerTimeOut(Integer id){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "复杂服务:" + Thread.currentThread().getName() + ",id=" + id;
    }

}
