package com.ostk.workexperience.twittermachine.service;

import javax.inject.Inject;
import javax.inject.Named;


import lombok.extern.log4j.Log4j2;
import twitter4j.*;


import java.io.File;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

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
        final Query query = new Query(queryString);
        query.setCount(5);
        query.setResultType(Query.ResultType.popular);
        query.setLocale(Locale.ENGLISH.getLanguage());
        QueryResult result;
        try {
          result = twitter.search(query);
          log.info("Successfully got {} tweets", result.getCount());
          return result.getTweets();
        }
        catch (final TwitterException e) {
          e.printStackTrace();
          return Collections.emptyList();
        }
      }

        @Override
        public List<Status> fetchTimeline() {
            Paging paging = new Paging ();
            paging.setCount (5);
            try {

                ResponseList<Status> result = twitter.getHomeTimeline (paging);
                log.info ("Successfully got timeline");
                return result;
            } catch (final TwitterException e) {
                e.printStackTrace ();
                return Collections.emptyList ();
            }

      }

        @Override
        public void upload(File timon, String caption) {
          try {
                UploadedMedia um = twitter.tweets ().uploadMedia (timon);
                StatusUpdate su = new StatusUpdate (caption);
                su.setMediaIds (um.getMediaId ());
                twitter.tweets ().updateStatus (su);
                log.info ("Successfully Uploaded Media File");
            } catch (final TwitterException e) {
                e.printStackTrace ();
            }






        }

    }


