package com.ostk.workexperience.twittermachine.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Inject;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.Status;

import java.util.ArrayList;

import java.util.List;

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
    twitter.publish(tweetMessage);
    return ResponseEntity.ok("Message Successfully published");
  }

  @PostMapping(value = "hello-world")
  public ResponseEntity helloWorld(final String message) {
    log.info("Message received: {}", message);
    return ResponseEntity.ok("you said: " + message);
  }

  @PostMapping(value = "challenge")
  public ResponseEntity sendTweet(final String[] messages){
        int i;
      log.info("Message received: {}", messages);
      for (i= 0; i <= 5; i++) {
          twitter.publish(messages[i]);
      }

    return ResponseEntity.ok("Message Successfully published");
  }

  @PostMapping(value = "search")
  public ResponseEntity searchTweets(final String queryString) {
    int i;
    log.info("Searching for: {}", queryString);
    final List<Status> tweets = twitter.search(queryString);// <- Something in there might be broken

          List<String> filteredList= new ArrayList<> ();
          for (Status entry : tweets) {
               String john = entry.getText ();
               filteredList.add (john);
         }


    return ResponseEntity.ok(filteredList);
  }

  @PostMapping(value = "timeline")
  public ResponseEntity fetchTimeline() {
    log.info("Fetching Timeline");
    final List<Status> tweets = twitter.fetchTimeline();
    return ResponseEntity.ok (tweets);
  }


    @PostMapping(value = "Upload Image")
    public ResponseEntity uploadMedia(final MultipartFile josh, String message) throws IOException {
        log.info("Uploading");
        File newJosh = multiToFile (josh);
        twitter.upload (newJosh, message);
        return ResponseEntity.ok ("Josh has been uploaded");
    }

    private File multiToFile(final MultipartFile multipartFile) throws IOException {
        final File file = new File(multipartFile.getOriginalFilename());
        if(file.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(multipartFile.getBytes());
            }
            return file;
        }
        return null;

    }
}
