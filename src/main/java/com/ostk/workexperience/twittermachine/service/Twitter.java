package com.ostk.workexperience.twittermachine.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.multipart.MultipartFile;

import com.ostk.workexperience.twittermachine.FileUtils;

import lombok.extern.log4j.Log4j2;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
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

  @Override
  public void publishMedia(final MultipartFile file, final String message) {
    final Status result = null;
    final StatusUpdate statusUpdate = new StatusUpdate("Some Message");
    try {
      final File fileToUpload = FileUtils.convertToUploadFile(file);
      statusUpdate.setMedia(null);
      twitter.updateStatus(statusUpdate);
      log.info("Successfully published [{}]", result.getText());
    }
    catch (final Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Status> fetchTimeline() {
    final ResponseList<Status> result;
    try {
      result = twitter.timelines().getHomeTimeline();
      log.info("Successfully got [{}] results", result.size());
      return result;
    }
    catch (final TwitterException e) {
      e.printStackTrace();
      return null;
    }
  }
}
