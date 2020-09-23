/*
 * Date: 2020-09-07
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 */

package rj222nq_assign1;
import java.util.Scanner;

//Exercise 3
public class SquareRoot {

    public static void main(String[] args) {
        getUserInput();
    }

    // Get the user input
    public static void getUserInput() {
        double key = 25;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("This program estimate square roots. \n" +
                "Enter an integer to estimate the square root of: " + key);
            double guess = scanner.nextDouble();
            calculateGuesses(guess, key);
        }
    }
    // Present user guess
    public static void calculateGuesses(double guess, double key) {

        System.out.println("Current guess " + guess);
        continues(guess, key);

    }
    // Calculate the guess and continue/discontinue the game
    public static void continues(double guess, double key) {
        double correctAnswer = Math.pow(key, 0.5);
        double percent = guess / correctAnswer;

        if (percent >= 0.9 && percent <= 1.1) {
            System.out.println("Congratulations!\nThe estimated square root of " + key + " is " + correctAnswer);

        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                guess = scanner.nextDouble();
                calculateGuesses(guess, key);

            }
        }
    }
}