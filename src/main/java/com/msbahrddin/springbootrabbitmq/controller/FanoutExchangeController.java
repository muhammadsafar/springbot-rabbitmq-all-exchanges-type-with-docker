package com.msbahrddin.springbootrabbitmq.controller;

import com.msbahrddin.springbootrabbitmq.dto.User;
import com.msbahrddin.springbootrabbitmq.publisher.FanoutExchangePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rabbitmq/fanout")
public class FanoutExchangeController {

    private FanoutExchangePublisher fanoutExchangePublisher;

    public FanoutExchangeController(FanoutExchangePublisher fanoutExchangePublisher) {
        this.fanoutExchangePublisher = fanoutExchangePublisher;
    }

    @PostMapping("/queueA")
    public ResponseEntity<User> sendUserFanoutExchangeA(@RequestBody User user) {
        fanoutExchangePublisher.sendMessageFanoutA(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/queueB")
    public ResponseEntity<User> sendUserFanoutExchangeB(@RequestBody User user) {
        fanoutExchangePublisher.sendMessageFanoutB(user);
        return ResponseEntity.ok(user);
    }

}
