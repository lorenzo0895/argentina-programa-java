package com.argProgramaSpallione.ArgentinaPrograma.Responses;

public class IException {
  private String error;

  public IException() {
  }

  public IException(String error) {
    this.error = error;
  }

  public String getError() {
    return this.error;
  }

  public void setError(String error) {
    this.error = error;
  }

}
