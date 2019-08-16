package com.ostk.workexperience.twittermachine.service;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ITwitter {
    void publish(String message) throws TwitterException;

    void publishMedia(MultipartFile file, String message);

    List<Status> fetchTimeline();
}


