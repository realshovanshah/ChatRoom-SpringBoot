package com.realshovanshah.chatroom.service;

import com.realshovanshah.chatroom.model.ChatForm;
import com.realshovanshah.chatroom.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {

    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        newMessage.setMessageText(chatForm.getMessageText());
        chatMessages.add(newMessage);
    }

    public List<ChatMessage> getMessages() {
        return chatMessages;
    }
}
