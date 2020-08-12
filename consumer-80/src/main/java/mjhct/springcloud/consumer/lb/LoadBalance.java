package mjhct.springcloud.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

    ServiceInstance choose(List<ServiceInstance> serviceInstances);

}
