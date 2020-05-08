package com.github.messenger_server.controller;

import com.github.messenger_server.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message inputMessage) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        Message outputMessage = new Message(inputMessage.getFrom(), inputMessage.getText(), time);
        log.info("Got message: " + outputMessage);
        return outputMessage;
    }
}
