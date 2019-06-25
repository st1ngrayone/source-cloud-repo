package com.test;

import lombok.extern.slf4j.Slf4j;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Receiver {

    @JmsListener(destination = "${queue_in}", containerFactory = "factory")
    public void receiveMessage(UUID id) {
        log.info("Received id {}", id);
    }
}
