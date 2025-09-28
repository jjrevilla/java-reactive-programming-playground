package com.example.reactive.pub_sub.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherImpl implements Publisher<String> {

  @Override
  public void subscribe(final Subscriber<? super String> subscriber) {
    subscriber.onSubscribe(new SubscriptionImpl(subscriber));
  }
}