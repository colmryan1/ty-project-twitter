package com.ostk.workexperience.twittermachine.service;

import org.springframework.http.ResponseEntity;
import twitter4j.Status;
import twitter4j.TwitterException;
import java.io.File;
import java.util.List;

public interface ITwitter {
    void publish(String message) throws TwitterException;

    List<Status> search(String query) throws TwitterException;

    List<Status> fetchTimeline() throws TwitterException;

    void upload(File timon, String message) throws  TwitterException;
}


