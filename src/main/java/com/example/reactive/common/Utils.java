package com.example.reactive.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utils {

  private static final Faker FAKER = new Faker();

  public static String randomQuote() {
    return FAKER.rickAndMorty().quote();
  }

  public static void sleep(final int seconds) {
    try {
      Thread.sleep(Duration.ofSeconds(seconds));
    } catch (InterruptedException exception) {
      Thread.currentThread().interrupt();
    }
  }
}