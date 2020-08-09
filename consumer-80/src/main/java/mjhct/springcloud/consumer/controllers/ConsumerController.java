package mjhct.springcloud.consumer.controllers;

import mjhct.springcloud.commons.entities.CommonCode;
import mjhct.springcloud.commons.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @GetMapping("/test01")
    public String test01(){
        return "Hello World!";
    }

    @GetMapping("/test02")
    public CommonResult test02(){
        return new CommonResult(CommonCode.SUCCESS);
    }

}
