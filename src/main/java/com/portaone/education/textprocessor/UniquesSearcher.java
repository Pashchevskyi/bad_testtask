package com.portaone.education.textprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UniquesSearcher {
  private String text;

  public UniquesSearcher(String text) {
    this.text = text;
  }

  private static List<Character> apply(String w) {
    List<Character> letters = new ArrayList<>(w.length());
    for (Character c : w.toCharArray()) {
      letters.add(c);
    }
    return letters;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String retrieveUniqueFromUniques() {
    List<String> textWords = retrieveWords();
    String uniqueCharacters = retrieveUniqueCharacters(textWords);
    List<String> uniqueCharactersList = new ArrayList<>();
    uniqueCharactersList.add(uniqueCharacters);
    return retrieveUniqueCharacters(uniqueCharactersList);
  }

  private List<String> retrieveWords() {
    this.text = this.text.replaceAll("\\s+", " ");
    String[] words = text.split(" ");
    List<String> trimmedWords = new ArrayList<>();
    Arrays.stream(words).forEach(w -> trimmedWords
        .add(w.replaceAll("[?!.,:;]", "")));
    return trimmedWords;
  }

  private String retrieveUniqueCharacters(List<String> words) {
    StringBuilder resultStringBuilder = new StringBuilder();
    List<List<Character>> wordsLetters = words.stream().map(UniquesSearcher::apply).collect(Collectors.toList());
    List<Character> uniqueCharacters = wordsLetters.stream().map(wl -> wl.stream()
        .filter(l -> Collections.frequency(wl, l) == 1).findFirst().orElse('\0'))
        .collect(Collectors.toList());
    for (Character uc : uniqueCharacters) {
      resultStringBuilder.append(uc);
    }
    return resultStringBuilder.toString();
  }
}
