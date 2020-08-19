package mjhct.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${config.value}")
    private String value;

    @GetMapping(value = "/value/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getValue(){
        return value;
    }

}
