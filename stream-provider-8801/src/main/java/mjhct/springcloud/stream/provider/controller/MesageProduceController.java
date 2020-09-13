package mjhct.springcloud.stream.provider.controller;

import mjhct.springcloud.commons.entity.CommonCode;
import mjhct.springcloud.commons.entity.CommonResult;
import mjhct.springcloud.stream.provider.service.MessageProduceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MesageProduceController {

    @Resource
    private MessageProduceService messageProduceService;

    @GetMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult send(){
        messageProduceService.send();
        return new CommonResult(CommonCode.SUCCESS);
    }

}
