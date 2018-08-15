package pl.uz.zgora.api_gateway.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.uz.zgora.api_gateway.rest.GeneralHttpErrorHandler;

@Configuration
public class AppConfig {

  @Bean
  public GeneralHttpErrorHandler generalHttpErrorHandler() {
    return new GeneralHttpErrorHandler();
  }
}
