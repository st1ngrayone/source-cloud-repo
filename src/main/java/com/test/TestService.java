package com.test;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class TestService {

    private final JmsTemplate jmsTemplate;
    private final String QUEUE_IN;

    @Autowired
    public TestService(JmsTemplate jmsTemplate, @Value("${queue_in}") String queue_in) {
        this.jmsTemplate = jmsTemplate;
        QUEUE_IN = queue_in;
    }

    @Scheduled(initialDelay = 100, fixedRate = 5000)
    public void sendValue() {
        UUID id = newId();
        log.info("Sending value {}", id);
        jmsTemplate.convertAndSend(QUEUE_IN, id);
    }

    private UUID newId(){
        return UUID.randomUUID();
    }
}
