package com.msbahrddin.springbootrabbitmq.controller;

import com.msbahrddin.springbootrabbitmq.publisher.DefaultExchangePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rabbitmq/default")
public class DefaultExchangeController {

    private DefaultExchangePublisher defaultExchangePublisher;

    public DefaultExchangeController(DefaultExchangePublisher defaultExchangePublisher) {
        this.defaultExchangePublisher = defaultExchangePublisher;
    }

    @PostMapping("/queueA/{message}")
    public ResponseEntity<String> sendMessageDefaultExchangeQueueA(@PathVariable String message){
        defaultExchangePublisher.sendMessageDefaultExchangeQueueA(message);
        return ResponseEntity.ok("Message sent to Rabbit MQ ...");
    }

    @PostMapping("/queueB/{message}")
    public ResponseEntity<String> sendMessageDefaultExchangeQueueB(@PathVariable String message){
        defaultExchangePublisher.sendMessageDefaultExchangeQueueB(message);
        return ResponseEntity.ok("Message sent to Rabbit MQ ...");
    }
}
