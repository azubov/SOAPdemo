package ru.lanit.SoapDemo.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.lanit.soapdemo.messages.Request;
import ru.lanit.soapdemo.messages.ResponseWithMessages;

@Endpoint
public class MessageEndpoint {
    private static final String NAMESPACE_URI = "http://lanit.ru/SOAPdemo/chat";

    private MessageRepository repository;

    @Autowired
    public MessageEndpoint(MessageRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Request")
    @ResponsePayload
    public ResponseWithMessages getCountry(@RequestPayload Request request) {
        ResponseWithMessages response = new ResponseWithMessages();
        response.setMessageList(repository.getAll());

        return response;
    }
}
