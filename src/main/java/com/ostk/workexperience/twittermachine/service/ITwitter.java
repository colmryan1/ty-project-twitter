package com.ostk.workexperience.twittermachine.service;

import twitter4j.TwitterException;

public interface ITwitter {
    void publish(String message) throws TwitterException;
}


