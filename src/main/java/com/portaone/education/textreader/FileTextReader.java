package com.portaone.education.textreader;

import com.portaone.education.textreader.api.TextReadable;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader implements TextReadable {

  private final String fileName;

  public FileTextReader() {
    fileName = "input.txt";
  }
  public FileTextReader(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String read() {
    char[] textFromFile = new char[1024];
    String text = "";
    StringBuilder sb = new StringBuilder();
    try (FileReader fileReader = new FileReader(this.fileName)) {
      fileReader.read(textFromFile);
      text = sb.append(textFromFile).toString();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return text;
  }
}
