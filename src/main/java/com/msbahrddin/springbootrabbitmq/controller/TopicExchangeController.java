package com.msbahrddin.springbootrabbitmq.controller;

import com.msbahrddin.springbootrabbitmq.dto.User;
import com.msbahrddin.springbootrabbitmq.publisher.TopicExchangePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rabbitmq/topic")
public class TopicExchangeController {

    private TopicExchangePublisher topicExchangePublisher;

    public TopicExchangeController(TopicExchangePublisher topicExchangePublisher) {
        this.topicExchangePublisher = topicExchangePublisher;
    }

    @PostMapping("/queueA")
    public ResponseEntity<User> sendTopicExchangeQueueA(@RequestBody User user) {
        topicExchangePublisher.sendMessageTopicExchangeA(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/queueB")
    public ResponseEntity<User> sendTopicExchangeQueueB(@RequestBody User user) {
        topicExchangePublisher.sendMessageTopicExchangeB(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/queueAll")
    public ResponseEntity<User> sendTopicExchangeQueueAll(@RequestBody User user) {
        topicExchangePublisher.sendMessageTopicExchangeAll(user);
        return ResponseEntity.ok(user);
    }
}
