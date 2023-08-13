package com.portaone.education;

import com.portaone.education.exception.UnknownInputSourceException;
import com.portaone.education.textprocessor.UniquesSearcher;
import com.portaone.education.textreader.TextReaderFactory;
import com.portaone.education.textreader.api.TextReadable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

  public static void main(String[] args) {
    System.out.println("Would you like to input text from file or from console (f/c)? ");
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String c = "";
    Object inputSource = null;
    try {
      c = stdin.readLine();
      if ("c".equals(c) || "C".equals(c)) {
        inputSource = System.in;
      }
      if ("f".equals(c) || "F".equals(c)) {
        System.out.println("Input file name: ");
        inputSource = stdin.readLine();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    try {
      TextReadable tr = TextReaderFactory.create(inputSource);
      UniquesSearcher us = new UniquesSearcher(tr.read());
      String uniqueStrFromUniques = us.retrieveUniqueFromUniques();
      System.out.println(uniqueStrFromUniques);
    } catch (UnknownInputSourceException e) {
      System.out.println(e.getMessage());
    }
  }
}