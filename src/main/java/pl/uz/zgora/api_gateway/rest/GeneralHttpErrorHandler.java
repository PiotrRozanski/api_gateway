package pl.uz.zgora.api_gateway.rest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import pl.uz.zgora.api_gateway.rest.exception.GeneralCommunicationException;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

public class GeneralHttpErrorHandler implements ResponseErrorHandler {

  @Override
  public boolean hasError(@NotNull ClientHttpResponse response) throws IOException {
    return response.getStatusCode().is4xxClientError() ||
            response.getStatusCode().is5xxServerError();
  }

  @Override
  public void handleError(@NotNull ClientHttpResponse response) throws IOException {
    throw new GeneralCommunicationException(
            getHeaderValue(GeneralCommunicationException.GENERAL_ERROR_MESSAGE_HEADER, response),
            getHeaderValue(GeneralCommunicationException.GENERAL_ERROR_CODE_HEADER, response),
            response.getStatusCode().value(),
            IOUtils.toString(response.getBody()));
  }

  private String getHeaderValue(String headerKey, ClientHttpResponse response) {
    List<String> headerValues = response.getHeaders().get(headerKey);
    StringBuilder message = new StringBuilder();
    if (headerValues != null) {
      for (String value : headerValues) {
        message.append(value);
      }
    }
    return message.toString();
  }
}
