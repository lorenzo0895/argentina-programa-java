package com.argProgramaSpallione.ArgentinaPrograma.Responses;

public class IResponse<T> {
  private String status;
  private T response;

  public IResponse(T response) {
    if (response instanceof IException) {
      this.status = "error";
    } else {
      this.status = "success";
    }
    this.response = response;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public T getResponse() {
    return this.response;
  }

  public void setResponse(T response) {
    this.response = response;
  }

}
