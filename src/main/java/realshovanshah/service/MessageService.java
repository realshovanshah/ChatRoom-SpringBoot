package realshovanshah.service;

import realshovanshah.mapper.MessageMapper;
import realshovanshah.model.ChatForm;
import realshovanshah.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        newMessage.setMessageText(chatForm.getMessageText());
        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getAllMessages();
    }
}
