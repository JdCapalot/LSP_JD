/** Justin Cameron Davis 
 * 
 */

package org.howard.edu.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment2 {

  private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");

  public static void main(String[] args) {
    // File name
    String fileName = "src/main/resources/words.txt";

    // Store the word count in a HashMap
    HashMap<String, Integer> wordCount = new HashMap<>();

    // Read the file and count the occurrences of each word
    try (Scanner sc = new Scanner(new File(fileName))) {
      while (sc.hasNextLine()) {
        String line = sc.nextLine().toLowerCase();
        Matcher matcher = WORD_PATTERN.matcher(line);
        while (matcher.find()) {
          String word = matcher.group();
          if (word.length() > 3) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + fileName);
    }

    // Print the word count
    for (String word : wordCount.keySet()) {
      System.out.println(word + ": " + wordCount.get(word));
    }
  }

}
