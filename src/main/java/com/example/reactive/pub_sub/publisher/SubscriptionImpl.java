package com.example.reactive.pub_sub.publisher;

import com.example.reactive.common.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
@RequiredArgsConstructor
public class SubscriptionImpl implements Subscription {

  private static final int MAX_ITEMS_TO_EMIT = 10;

  private boolean cancelled;
  private int counter;

  private final Subscriber<? super String> subscriber;

  @Override
  public void request(final long itemsRequested) {
    if (cancelled) {
      return;
    }
    if (itemsRequested <= 0 || itemsRequested > MAX_ITEMS_TO_EMIT) {
      subscriber.onError(new IllegalArgumentException("Requested items is invalid or exceeds maximum allowed"));
      cancelled = true;
      return;
    }
    for (int i = 0; i < itemsRequested && counter < MAX_ITEMS_TO_EMIT; i++) {
      counter++;
      subscriber.onNext(counter + " -> " + Utils.randomQuote());
    }
    if (counter == MAX_ITEMS_TO_EMIT) {
      log.info("No more items to subscribe");
      subscriber.onComplete();
      cancelled = true;
    }
  }

  @Override
  public void cancel() {
    log.info("Subscriber is cancelled");
    cancelled = true;
  }
}
