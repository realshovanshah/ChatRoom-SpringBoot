package realshovanshah.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import realshovanshah.model.ChatForm;
import realshovanshah.service.MessageService;

import java.security.Principal;

@Controller
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @MessageMapping("/chats")
    public String processMessages(String message, Principal principal){
        return principal.getName() + ": " + message;
    }

}
