package mjhct.springcloud.provider.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult test(){
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

    @GetMapping(value = "/timeout", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult timeOut(){
        try {
            // 睡眠3秒超时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(CommonCode.SUCCESS, serverPort);
    }

}
