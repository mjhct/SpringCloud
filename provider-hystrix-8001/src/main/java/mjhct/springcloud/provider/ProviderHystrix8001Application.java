package mjhct.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderHystrix8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8001Application.class, args);
    }

    /**
     * 视频里的版本看不到监控数据是这样的问题和解决办法：
     * 此配置是为了监控服务，与服务容错本身无关，SpringCloud升级后的问题。
     * 不用管为什么了，这里知道用一下就可以了。
     *
     * 我用了最新的版本是另外一个问题，详情看hystrix-dashboard-9001依赖里面的说明吧。
     * 我选择更换监控的版本，改源码麻烦而且也不实用……
     * @return
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream"); // 这个路径就是要填的监控路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
     */

}
