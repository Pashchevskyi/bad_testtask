package com.portaone.education.textreader;

import com.portaone.education.textreader.api.TextReadable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleTextReader implements TextReadable {
  private final InputStream in;

  public ConsoleTextReader() {
    this.in = System.in;
  }

  public ConsoleTextReader(InputStream in) {
    this.in = in;
  }

  @Override
  public String read() {
    String text = "";
    StringBuilder sb = new StringBuilder();
    try (BufferedReader stdin = new BufferedReader(new InputStreamReader(this.in))) {
      do {
        text = stdin.readLine();
        sb.append(text);
      } while (!(":q".equals(text)));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return sb.toString();
  }
}
