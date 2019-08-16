package com.ostk.workexperience.twittermachine.service;

import twitter4j.TwitterException;

import org.springframework.web.multipart.MultipartFile;

public interface ITwitter {
    void publish(String message) throws TwitterException;

    void publishMedia(MultipartFile file, String message);
}


