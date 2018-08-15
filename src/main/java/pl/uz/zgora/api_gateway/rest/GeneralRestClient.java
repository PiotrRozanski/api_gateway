package pl.uz.zgora.api_gateway.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GeneralRestClient {

  private static final Logger log = LoggerFactory.getLogger(GeneralRestClient.class);
  private GeneralHttpErrorHandler generalHttpErrorHandler;

  public GeneralRestClient(GeneralHttpErrorHandler generalHttpErrorHandler) {
    this.generalHttpErrorHandler = generalHttpErrorHandler;
  }
}
