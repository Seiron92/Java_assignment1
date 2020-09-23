/*
 * Date: 2020-09-07
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 */
package rj222nq_assign1;
import java.util.Scanner;

//Exercise 2
public class ArmstrongNumber {

    public static void main(String[] args) {
        getUserInput();
    }

    public static void getUserInput() {
        int startingNumber = 0;
        int endingNumber = 0;
        try (Scanner scanner = new Scanner(System.in)) {

            // Get user start range
            System.out.print("Enter the starting number of the range: ");
            String startingNumberInput = scanner.nextLine();
            startingNumber = Integer.parseInt(startingNumberInput);

            // Get user end range
            System.out.print("Enter the ending number of the range: ");
            String endingNumberInput = scanner.nextLine();

            // Present the numbers
            System.out.print("\nThe Armstrong numbers between the given range are : \n");
            endingNumber = Integer.parseInt(endingNumberInput);
            
            // Display result
            result(endingNumber, startingNumber);
            // Continue game
            continueGame();
        }

    }

    /* Calculate the input
     * Credits: https://www.youtube.com/watch?v=KkAiNXR42fk 
     */
    public static void calculate(int startingNumber) {
        int temp = startingNumber;
        int r, sum = 0;

        while (startingNumber > 0) {

            r = startingNumber % 10;
            startingNumber = startingNumber / 10;
            sum = sum + r * r * r;

            if (temp == sum) {
                System.out.println(sum);
            }
        }
    }
    // Get the result by iterate over startingNumber and call the "calculate-function"
    public static void result(int endingNumber, int startingNumber) {
    	 while (startingNumber < endingNumber) {
             startingNumber++;
             calculate(startingNumber);
         }
    }

    // Continue game if user press "Y"
    public static void continueGame() {
        System.out.print("\nDo you want to repeat? (Y/N) ");
        try (Scanner scanner = new Scanner(System.in)) {
            String continueGame = scanner.nextLine();
            switch (continueGame) {
                case "Y":
                	getUserInput();
                    break;
            }
        }
    }
}