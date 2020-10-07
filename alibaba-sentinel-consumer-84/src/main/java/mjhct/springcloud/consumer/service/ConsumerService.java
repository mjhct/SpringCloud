package mjhct.springcloud.consumer.service;

import mjhct.springcloud.commons.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nacos-provider-service", fallback = ConsumerFallBackService.class)
public interface ConsumerService {

    @GetMapping("/provider/data/{id}")
    CommonResult getData(@PathVariable(value = "id") Integer id);

}
