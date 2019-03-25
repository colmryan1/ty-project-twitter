package com.ostk.workexperience.twittermachine.config;

import lombok.extern.log4j.Log4j2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

@EnableSwagger2
@Configuration
@Log4j2
public class Config {

  @Value("${twitter.debug}")
  private Boolean debug;

  @Value("${twitter.oauth.consumerKey}")
  private String consumerKey;

  @Value("${twitter.oauth.consumerSecret}")
  private String consumerSecret;

  @Value("${twitter.oauth.accessToken}")
  private String accessToken;

  @Value("${twitter.oauth.accessTokenSecret}")
  private String accessTokenSecret;

  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.any())
        .paths(Predicates.not(PathSelectors.regex("/error.*")))
        .build();
  }

  @Bean
  public Twitter configTwitterAccount() {
    final ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(debug)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessTokenSecret);
    log.info("Building new twitter credentials");
    return new TwitterFactory(cb.build()).getInstance();

  }

}
