package com.example.springboot_active_mq.publish.controller;

import com.example.springboot_active_mq.consumer.component.MessageConsumer;
import com.example.springboot_active_mq.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate; // helper class for sending and receiving message

    @Autowired
    private MessageConsumer messageConsumer;

    @PostMapping("publishMesssage")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessage systemMessage) {

        try {
            jmsTemplate.convertAndSend("hamzacode-queue", systemMessage);
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
