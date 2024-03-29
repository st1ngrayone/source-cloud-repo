package com.test;

import com.test.domain.Message;
import lombok.extern.slf4j.Slf4j;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @JmsListener(destination = "${queue_in}", containerFactory = "factory")
    public void receiveMessage(Message message) {
        log.info("Received message, id {}", message.getId());
    }
}
