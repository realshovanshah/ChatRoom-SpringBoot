package realshovanshah.controller;

import realshovanshah.model.ChatForm;
import realshovanshah.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model, Authentication authentication) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        model.addAttribute("username", authentication.getName());
        return "home";
    }

//    @PostMapping
//    public void postChatMessage(Authentication authentication, ChatForm chatForm, Model model) {
//        chatForm.setUsername(authentication.getName());
//        this.messageService.addMessage(chatForm);
//        chatForm.setMessageText("");
//        model.addAttribute("chatMessages", this.messageService.getChatMessages());
////        return "home";
//    }

    

}

