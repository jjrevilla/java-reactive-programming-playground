package com.example.reactive.pub_sub;

import com.example.reactive.common.Utils;
import com.example.reactive.pub_sub.publisher.PublisherImpl;
import com.example.reactive.pub_sub.subscriber.SubscriberImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  void main() {
    demo1();
    demo2();
    demo3();
    demo4();
  }

  void demo1() {
    log.info("demo1");
    final var publisher = new PublisherImpl();
    final var subscriber = new SubscriberImpl();
    publisher.subscribe(subscriber);
  }

  void demo2() {
    log.info("demo2");
    final var publisher = new PublisherImpl();
    final var subscriber = new SubscriberImpl();
    publisher.subscribe(subscriber);
    subscriber.getSubscription().request(3);
    Utils.sleep(2);
    subscriber.getSubscription().request(3);
    Utils.sleep(2);
    subscriber.getSubscription().request(3);
    Utils.sleep(2);
    subscriber.getSubscription().request(3);
  }

  void demo3() {
    log.info("demo3");
    final var publisher = new PublisherImpl();
    final var subscriber = new SubscriberImpl();
    publisher.subscribe(subscriber);
    subscriber.getSubscription().request(3);
    Utils.sleep(2);
    subscriber.getSubscription().cancel();
    subscriber.getSubscription().request(3);
    Utils.sleep(2);
  }

  void demo4() {
    log.info("demo4");
    final var publisher = new PublisherImpl();
    final var subscriber = new SubscriberImpl();
    publisher.subscribe(subscriber);
    subscriber.getSubscription().request(3);
    Utils.sleep(2);
    subscriber.getSubscription().request(11);
    Utils.sleep(2);
  }
}