package top.krasus1966.springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import top.krasus1966.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Krasus1966
 * @date 2020/6/24 15:25
 **/
@EnableBinding(Source.class) // 定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial:"+serial);
        return null;
    }
}
