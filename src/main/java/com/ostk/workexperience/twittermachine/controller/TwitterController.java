package com.ostk.workexperience.twittermachine.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ostk.workexperience.twittermachine.service.Twitter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/")
public class TwitterController {

  @Inject
  private Twitter twitter;

  @PostMapping(value = "tweet")
  public ResponseEntity sendTweet(final String tweetMessage) {
    log.info("Message received: {}", tweetMessage);
    final String message = null;
    twitter.publish(message);
    return ResponseEntity.ok("Message Successfully published");
  }

  @PostMapping(value = "hello-world")
  public ResponseEntity helloWorld(final String message) {
    log.info("Message received: {}", message);
    return ResponseEntity.ok("you said: " + message);
  }

  @PostMapping(value = "manyTweets")
  public ResponseEntity sendTweet(final String[] messages) {
    log.info("Message received: {}", messages);
    final String myMessage = null;
    twitter.publish(myMessage);
    return ResponseEntity.ok("Message Successfully published");
  }

  @PostMapping(value = "Upload Image")
  public ResponseEntity uploadMedia(final MultipartFile file, final String message) {
    log.info("Message received: {}", message);
    twitter.publishMedia(file, message);
    return ResponseEntity.ok("Josh has been uploaded");
  }

  @PostMapping(value = "timeline")
  public ResponseEntity fetchTimeline() {
    log.info("Fetching Timeline");
    twitter.fetchTimeline();
    return ResponseEntity.ok(null);
  }
}
