/*
 * Date: 2020-09-08
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 */

package rj222nq_assign1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        // Call the method "getUserInput"
        getUserInput();
    }

    // Get user input
    public static void getUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Write a word: \n");
            String word = scanner.nextLine(); // Assign a variable the scanners next line
            anagram(word, "");
        }
    }

    public static void anagram(String word, String anagram) {
        if (word.length() == 0) {
            // Read the text document
            Scanner txtscan;
            try {
                txtscan = new Scanner(new File("src/rj222nq_assign1/wordlist.txt"));
                while (txtscan.hasNextLine()) {
                    String text = txtscan.nextLine();
                    result(anagram, text); // Pass the anagram and the text to the method "result"
                }
                txtscan.close(); // Close the scanner
            } catch (FileNotFoundException e) { // Display error message
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }

        for (int i = 0; i < word.length(); i++) { // loop through the (user input) word
            char wordAsChar = word.charAt(i); // Assign a char variable the value of every word (each letter)
            String assambled = word.substring(0, i) + word.substring(i + 1); // Put the word together
            /* Call the same method (anagram) and pass the words along in order to compare them
             * to the word in the word list
             */
            anagram(assambled, anagram + wordAsChar);
        }

    }

    // Print the result to the user
    public static void result(String anagram, String text) {
        if (anagram.equals(text)) { // If the word is in the word list
            System.out.println(text); // print the word
        }
    }

}