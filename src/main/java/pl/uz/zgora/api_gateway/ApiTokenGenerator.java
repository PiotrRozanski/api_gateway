package pl.uz.zgora.api_gateway;

import java.util.UUID;

public class ApiTokenGenerator {

  private static String generateUUID() {
    return UUID.randomUUID().toString();
  }
}
