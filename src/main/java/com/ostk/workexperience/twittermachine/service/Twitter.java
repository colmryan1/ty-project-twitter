package com.ostk.workexperience.twittermachine.service;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.extern.log4j.Log4j2;
import twitter4j.Status;
import twitter4j.TwitterException;

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
}
