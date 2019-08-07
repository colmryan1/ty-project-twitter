package com.ostk.workexperience.twittermachine.service;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.extern.log4j.Log4j2;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.Collections;
import java.util.List;

@Log4j2
@Named
public class Twitter implements ITwitter {

  @Inject
  private twitter4j.Twitter twitter;

  @Override
  public void publish(final String message) {
    final Status result;
    try {
      result = twitter.updateStatus(message);
      log.info("Successfully published [{}]", result.getText());
    }
    catch (final TwitterException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Status> search(String queryString) {
    final Query query = new Query();
    QueryResult result;
    try {
      result = twitter.search(null);
      log.info("Successfully got {} tweets", result.getCount());
      return result.getTweets();
    }
    catch (final TwitterException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }
}
