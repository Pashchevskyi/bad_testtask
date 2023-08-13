package com.portaone.education.textreader;

import com.portaone.education.exception.UnknownInputSourceException;
import com.portaone.education.textreader.api.TextReadable;
import java.io.InputStream;

public class TextReaderFactory {
  public static TextReadable create(Object inputSource) throws UnknownInputSourceException {
    if (inputSource instanceof InputStream) {
      return new ConsoleTextReader((InputStream) inputSource);
    }
    if (inputSource instanceof String) {
      return new FileTextReader((String) inputSource);
    }
    throw new UnknownInputSourceException();
  }
}
