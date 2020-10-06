package mjhct.springcloud.consumer.lb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalance{

    private static final Logger logger = LoggerFactory.getLogger(MyLB.class);

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current, next));
        logger.info("=====访问次数next:" + next);
        return next;
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
