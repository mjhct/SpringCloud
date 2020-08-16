package mjhct.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("provider-hystrix-service")
public interface ProviderService {

    @GetMapping(value = "/provider/hystrix/ok/{id}")
    String providerOk(@PathVariable("id") Integer id);

    @GetMapping(value = "/provider/hystrix/timeout/{id}")
    String providerTimeout(@PathVariable("id") Integer id);

}
