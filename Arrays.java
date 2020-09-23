/*
 * Date: 2020-09-20
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;

public class Arrays {

    // Takes the input numbers and adds to sum, the average is calculated by taking the sum and divide it by the number of numbers in the array (array.length)
    public static int average(int[] arr) {
        int sum = 0; // Initialize variable sum
        for (int i = 0; i < arr.length; i++) { // loop through the array
            sum += arr[i]; // add 1 to the sum for every iteration in order to calculate the sum of the array
        }

        int average = ((int) sum) / arr.length; // divide the sum with the number of digits in the array (length)
        return average; // return the average
    }

    // Takes the input numbers and calculate the max number by looping the array and detect the largest number.
    public static int max(int[] arr) {
        int max = arr[0]; // Initialize an int and set the value to the first value (first index) of the array
        for (int i = 0; i < arr.length; i++) // loop through the array
        {
            if (max < arr[i]) // if the current number of the loop in the array is larger than the variable max
            {
                max = arr[i]; // assign this number to the variable max
            }
        }
        return max; // return the max variable
    }

    /* Add number */
    public static int[] addN(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) { // loop through the array

            // Detect if last iteration
            /* This is on order to not have a comma at 
             * the end of the last result of the iteration */
            if (i == arr.length - 1) { // if variable i is the last of the array length (-1)
                System.out.print(arr[i] + n); // Print the message of the array value + the added number (n)
            } else {
                System.out.print(arr[i] + n + ","); // Print the message of the array value + the added number (n) and separate by a comma
            }
        }
        return arr;
    }

    /* Reverse */
    public static int[] reverse(int[] arr) {
        int[] myIntArray = new int[arr.length]; // Create a new int array and assign it the value of the (passed) array length
        for (int i = arr.length - 1; i >= 0; i--) { // Loop through the array from the END to the START

            myIntArray[i] = arr[i]; // assign the value of the looped array to the newly created one
            // Detect if last iteration, same principle as in the "addN-method"
            if (i == myIntArray.length - 1) {
                System.out.print(myIntArray[i]);

            } else {
                System.out.print("," + myIntArray[i]);
            }
        }
        return myIntArray; // Return the (new) array
    }

    /* Replace */
    void replaceAll(int[] arr, int old, int nw) {

        for (var i = 0; i < arr.length; i++) { // Loop through the array
            if (arr[i] == old) { // If the array value equals the old (passed) value
                arr[i] = nw; // Assign the new (passed) value to it 
            }
            // Detect if last iteration, same principle as in the "addN-method"
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    /* Sort */
    //Credit: https://study.com/academy/lesson/how-to-sort-an-array-in-java.html
    public static int[] sort(int[] arr) {
        int temp; // Initialize an int variable
        for (var i = 0; i < arr.length; i++) { // Loop through the array
            for (int j = i; j > 0; j--) { // Loop thought the outside array in reverse order
                if (arr[j] < arr[j - 1]) { // if the outside array is less than the outside array (value) minus 1
                    temp = arr[i]; // Assign this value to the temp variable
                    arr[j] = arr[j - 1]; // Assign the value of the outside array current value to the outside array current value minus 1

                    // Detect if last iteration, same principle as in the "addN-method"
                    if (i == arr.length - 1) {
                        System.out.print(temp + "," + arr[j]); // + add the "missing" index value 
                    } else {
                        System.out.print(temp + ",");
                    }
                }
            }
        }
        return arr; // return the array
    }


    public static boolean hasSubString(int[] arr, int[] sub) {
        // Initialize variables
        int i = 0;
        int j = 0;

        for (i = 0; i < sub.length; i++) { // loop through the sub array
            for (j = 0; j < arr.length; j++) { // loop through the arr array
                if (sub[i] == arr[j]) { // If the sub value is equal to the arr value

                    if (sub[i] != arr[j]) { // If the values are not equal
                        return false; // return false
                    }
                    break; // Because the 2 values are equal break the loop
                }
            }

            if (j == arr.length) { // if the current loop "index" is the value of the array length (to keep the iteration to stop)
                return false; // return false
            }
        }
        return true;
    }

    /* Difference */
    public static int[] absDif(int[] arr1, int[] arr2) {

        // Initialize variables
        int result = 0;
        int i = 0;
        int j = 0;

        try {
            if (arr1.length != arr2.length) { // If the 2 arrays isn't of the same size
                throw new IllegalArgumentException("The 2 arrays must be of the same size"); // Print error message
            }

            for (i = 0; i < arr1.length; i++) { // Loop through the first array (arr1)
                for (j = 0; j < arr2.length; j++) { // Loop through the second array (arr2)

                    result = arr1[i] - arr2[j]; // Assign the result variable to the value of the first array minus the value of the second array
                }
                // Detect if last iteration, same principle as in the "addN-method"
                if (i == arr1.length - 1) {
                    System.out.print(result);
                } else {
                    System.out.print(result + ",");
                }
            }

        } catch (Exception e) { // In order to use try I had to assign a catch
            System.out.println("The 2 arrays must be of the same size"); // The error message
        }
        return arr1; // Return the first array
    }

}