package com.portaone.education.exception;

public class UnknownInputSourceException extends Exception {
  public UnknownInputSourceException() {
    super("Unknown input source exception (neither console, nor file...)");
  }
}
