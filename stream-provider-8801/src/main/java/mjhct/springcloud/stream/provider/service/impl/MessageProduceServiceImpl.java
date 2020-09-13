package mjhct.springcloud.stream.provider.service.impl;

import cn.hutool.core.util.IdUtil;
import mjhct.springcloud.stream.provider.service.MessageProduceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Source.class)
public class MessageProduceServiceImpl implements MessageProduceService {

    private static final Logger logger = LoggerFactory.getLogger(MessageProduceServiceImpl.class);

    /**
     * 默认有一个叫output的通道，所以配置里面没有任何叫output的通道配置也运行成功
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String no = IdUtil.fastSimpleUUID();
        output.send(MessageBuilder.withPayload(no).build());
        logger.info("流水号:{}", no);
        return null;
    }
}
