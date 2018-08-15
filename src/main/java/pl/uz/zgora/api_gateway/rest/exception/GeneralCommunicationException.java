package pl.uz.zgora.api_gateway.rest.exception;

public class GeneralCommunicationException extends RuntimeException {
  public static final String GENERAL_ERROR_CODE_HEADER = "ERROR_CODE";
  public static final String GENERAL_ERROR_MESSAGE_HEADER = "ERROR_MESSAGE";

  private int httpStatusCode;
  private String errorCode;
  private String bodyContents;

  public GeneralCommunicationException(String errorMessage, String errorCode, int httpStatusCode, String bodyContents) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.httpStatusCode = httpStatusCode;
    this.bodyContents = bodyContents;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getBodyContents() {
    return bodyContents;
  }

  public void setBodyContents(String bodyContents) {
    this.bodyContents = bodyContents;
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }

  @Override
  public String toString() {
    return bodyContents;
  }
}
