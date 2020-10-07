package mjhct.springcloud.consumer.service;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.springframework.stereotype.Service;

@Service
public class ConsumerFallBackService implements ConsumerService{
    @Override
    public CommonResult getData(Integer id) {
        return new CommonResult(CommonCode.FAIL, "openfeign兜底服务");
    }
}
