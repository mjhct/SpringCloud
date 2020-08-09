package mjhct.springcloud.consumer.controllers;

import mjhct.springcloud.commons.entities.CommonCode;
import mjhct.springcloud.commons.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    /**
     * produces：设置响应的数据类型
     * @return
     */
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult test(){
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

}
