package mjhct.springcloud.consumer.service;

import mjhct.springcloud.commons.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("provider-service")
public interface ProviderService {

    @GetMapping(value = "/provider/test")
    CommonResult test();

}
