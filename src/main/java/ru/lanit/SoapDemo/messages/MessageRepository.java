package ru.lanit.SoapDemo.messages;

import org.springframework.stereotype.Repository;
import ru.lanit.soapdemo.messages.Message;
import ru.lanit.soapdemo.messages.MessageList;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MessageRepository {

    List<Message> messages = new LinkedList<>();

    @PostConstruct
    public void initData() {
        Message message1 = new Message();
        message1.setFrom("User1");
        message1.setText("Hello from User1");
        messages.add(message1);

        Message message2 = new Message();
        message1.setFrom("User2");
        message1.setText("Hi from User2");
        messages.add(message2);
    }

    public MessageList getAll() {
        return (MessageList) messages;
    }

}
