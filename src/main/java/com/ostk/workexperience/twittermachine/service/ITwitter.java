package com.ostk.workexperience.twittermachine.service;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

public interface ITwitter {
  void publish(String message) throws TwitterException;
  List<Status> search(String query) throws TwitterException;
}
