package com.example.springboot_active_mq.consumer.component;

import com.example.springboot_active_mq.model.SystemMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.sound.midi.SysexMessage;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "hamzacode-queue")
    public void messageListener(SystemMessage systemMessage) {
        LOGGER.info("Message received, {}", systemMessage);
    }

}
