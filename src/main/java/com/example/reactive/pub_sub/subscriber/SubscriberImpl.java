package com.example.reactive.pub_sub.subscriber;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
@Getter
public class SubscriberImpl implements Subscriber<String> {

  private Subscription subscription;

  @Override
  public void onSubscribe(final Subscription subscription) {
    this.subscription = subscription;
  }

  @Override
  public void onNext(final String message) {
    log.info("Message received: {}", message);
  }

  @Override
  public void onError(final Throwable throwable) {
    log.error("Unexpected error: {}", throwable.getMessage(), throwable);
  }

  @Override
  public void onComplete() {
    log.info("Subscriber is complete");
  }
}