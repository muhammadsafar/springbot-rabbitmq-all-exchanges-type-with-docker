package com.msbahrddin.springbootrabbitmq.controller;

import com.msbahrddin.springbootrabbitmq.publisher.HeaderExchangePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rabbitmq/header")
public class HeaderExchangeController {

    private HeaderExchangePublisher headerExchangePublisher;

    public HeaderExchangeController(HeaderExchangePublisher headerExchangePublisher) {
        this.headerExchangePublisher = headerExchangePublisher;
    }

    @PostMapping("/queueA/{message}")
    public ResponseEntity<String> sendMessageHeaderA(@PathVariable String message) {
        headerExchangePublisher.sendMessageHeaderQueueA(message);
        return ResponseEntity.ok("Message sent to Rabbit MQ...");
    }

    @PostMapping("/queueB/{message}")
    public ResponseEntity<String> sendMessageHeaderB(@PathVariable String message) {
        headerExchangePublisher.sendMessageHeaderQueueB(message);
        return ResponseEntity.ok("Message sent to Rabbit MQ...");
    }

    @PostMapping("/queueAll/{message}")
    public ResponseEntity<String> sendMessageHeaderAll(@PathVariable String message) {
        headerExchangePublisher.sendMessageHeaderQueueAll(message);
        return ResponseEntity.ok("Message sent to Rabbit MQ...");
    }
}
