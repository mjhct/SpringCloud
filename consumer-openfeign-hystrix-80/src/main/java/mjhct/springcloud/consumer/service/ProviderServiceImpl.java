package mjhct.springcloud.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String providerOk(Integer id) {
        return "消费者80的feign调用兜底服务providerOk";
    }

    @Override
    public String providerTimeout(Integer id) {
        return "消费者80的feign调用兜底服务providerTimeout";
    }
}
