package top.krasus1966.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.springcloud.service.IMessageProvider;

/**
 * @author Krasus1966
 * @date 2020/6/24 15:31
 **/
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
