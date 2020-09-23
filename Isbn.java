/*
 * Date: 2020-09-07
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Exercise 1 
public class Isbn {

    public static void main(String[] args) {
        getUserInput();
    }


    public static void getUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input
            System.out.print("Enter the first 9 digits of an ISBN as integer: ");
            String input = scanner.nextLine(); // Read user input
            // Control string length
            if (input.length() != 9) {
                System.out.println("You must enter 9 digits");
            } else {
                calculate(input);
            }
        }
    }

    public static void calculate(String input) {
        int control = 0;
        int sum = 0;
        int lastDigit = 0;
        int userInput = Integer.parseInt(input); // Convert user input (string) to integer

        // Store user input in array
        if (userInput < 0) userInput = -userInput;
        List < Integer > individualNumbers = new LinkedList < Integer > ();

        while (userInput > 0) {
            individualNumbers.add(0, userInput % 10);
            userInput = userInput / 10;
        }
        // Push the missing 0 to the array
        if (input.startsWith("0")) {
            individualNumbers.add(0, 0);
        }

        // Loop through the array and calculate last digit
        for (int i: individualNumbers) {

            control++; // becomes 1 , 2 , 3 etc. for every iteration
            sum = i * control + (sum); // d1 * 1 + ..

        }

        lastDigit = (sum) % 11;
        lastDigit(lastDigit, input);

    }
    public static void lastDigit(int lastDigit, String input) {
        // If the last digit is 10
        String result = "";
        if (lastDigit == 10) {
            result = "X";
        } else {
            result = String.valueOf(lastDigit);
        }

        // Display the digit number
        System.out.println("The ISBN-10 number is: " + input + result);
    }

}