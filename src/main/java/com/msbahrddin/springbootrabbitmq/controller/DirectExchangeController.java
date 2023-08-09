package com.msbahrddin.springbootrabbitmq.controller;

import com.msbahrddin.springbootrabbitmq.dto.User;
import com.msbahrddin.springbootrabbitmq.publisher.DirectExchangePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rabbitmq/direct")
public class DirectExchangeController {

    /**
     * direct exchange me routing per routing key, / one on one
     */

    private DirectExchangePublisher directExchangePublisher;

    public DirectExchangeController(DirectExchangePublisher directExchangePublisher) {
        this.directExchangePublisher = directExchangePublisher;
    }

    @PostMapping("/queueA")
    public ResponseEntity<User> sendUserDirectExchangeA(@RequestBody User user){
        directExchangePublisher.sendMessageDirectExchangeA(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/queueB")
    public ResponseEntity<User> sendUserDirectExchangeB(@RequestBody User user){
        directExchangePublisher.sendMessageDirectExchangeB(user);
        return ResponseEntity.ok(user);
    }
}
