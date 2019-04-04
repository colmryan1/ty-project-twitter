package com.ostk.workexperience.twittermachine.controller;

import javax.inject.Inject;

import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ostk.workexperience.twittermachine.service.Twitter;

@Log4j2
@RestController
@RequestMapping(value = "/")
public class TwitterController {

  @Inject
  private Twitter twitter;

  @PostMapping(value = "tweet")
  public ResponseEntity sendTweet(final String tweetMessage) {
    log.info("Message received: {}", tweetMessage);
    final String myMessage = null;
    twitter.publish(myMessage);
    return ResponseEntity.ok("Message Successfully published");
  }

  @PostMapping(value = "hello-world")
  public ResponseEntity helloWorld(final String message) {
    log.info("Message received: {}", message);
    return ResponseEntity.ok("you said: " + message);
  }

  @PostMapping(value = "challenge")
  public ResponseEntity sendTweet(final String[] messages) {
    log.info("Message received: {}", messages);
    final String myMessage = null;
    twitter.publish(myMessage);
    return ResponseEntity.ok("Message Successfully published");
  }
}
