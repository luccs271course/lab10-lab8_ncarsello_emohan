package edu.luc.cs271.wordcount;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {

  public static void main(final String[] args) throws InterruptedException {

    // set up the scanner so that it separates words based on space and punctuation
    final Scanner input = new Scanner(System.in).useDelimiter("[^\\p{Alnum}]+");
    // final Scanner input = new File(input.nextLine());
    // input = new Scanner(file);

    // DONE?TODO complete this main program
    // 1. create a WordCounter instance
    Map<String, Integer> newMap = new HashMap<>();
    WordCounter wordy = new WordCounter(newMap);
    // 2. use this to count the words in the input
    wordy.countWords(input);
    // 3. determine the size of the resulting map
    int size = newMap.size();
    // 4. create an ArrayList of that size and
    // 5. store the map's entries in it (these are of type Map.Entry<String, Integer>
    List<Map.Entry<String, Integer>> list =
        new ArrayList<Map.Entry<String, Integer>>(newMap.entrySet());
    // 6. sort the ArrayList in descending order by count
    //    using Arrays.sort and an instance of the provided comparator (after fixing the latter)
    Map<String, List<String>> contacts = new TreeMap<String, List<String>>();

    // ArrayList arrraylist = Arrays.sort(DescendingByCount);
    Collections.sort(list, new DescendingByCount());
    // 7. print the (up to) ten most frequent words in the text
    for (int i = 0; i < 11; i++) {
      System.out.println(list.get(i));
    }
  }
}
