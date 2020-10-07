package com.realshovanshah.chatroom.controller;

import com.realshovanshah.chatroom.model.ChatForm;
import com.realshovanshah.chatroom.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String getHomePage(ChatForm chatForm, Model model){
        model.addAttribute("chatMessages", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping
    public String addMessage(ChatForm chatForm, Model model){
        messageListService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", messageListService.getMessages());
        return "home";
    }
}
