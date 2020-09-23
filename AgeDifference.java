/*
 * Date: 2020-09-08
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 */
package rj222nq_assign1;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.DateFormat;
import java.text.ParseException;

public class AgeDifference {
	// Initialize variable
	   public static String DATE_FORMAT = "yyyy-MM-dd";

	public static void main(String[] args) {
// Call method "getUserInput"
		getUserInputA();	
	}
	
	 // Get person A's birth date
    public static void getUserInputA() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Person A’s date of Birth (in format: " + DATE_FORMAT+ ")"); // Display the message
            String personAInput = scanner.nextLine(); // assign the variable from the scanner
           
            validateInputA(personAInput); // Call the function "validateInputA" and pass along the input
        }
    }
   
	 // Get person B's birth date
    public static void getUserInputB(String personAInput) {
        try (Scanner scanner = new Scanner(System.in)) {
          
            System.out.print("Enter Person B’s date of Birth (in format: " + DATE_FORMAT+ ")"); // Display the message
            String personBInput = scanner.nextLine(); // assign the variable from the scanner
       
            validateInputB(personBInput, personAInput); // Call the function "validateInputB" and pass along the input
        }
    }

		 /*
		  * Validate the input for person B
		  * 1. Separate the sting by the separator (-)
		  * 2. Check if the input is a date
		  * 3. Check if the input format is correct by comparing the length of each part 
		  * 4. Continue to get person B's birth date.
		  */
    public static void validateInputA(String personAInput) {
    	//1. 
    	 String PersonA = personAInput; 
         String[] dateOfBirth = PersonA.split("-", 5);

         try {
        	 // 2.
             DateFormat checkIfDate = new SimpleDateFormat(DATE_FORMAT);
             checkIfDate.setLenient(false);
             checkIfDate.parse(personAInput);
             // 3. Year
 			if(dateOfBirth[0].length() != 4) {
 				 System.out.print("Year must be in 4 digits\n");
 					getUserInputA();
 			}
 			// 3. Month
 			else if(dateOfBirth[1].length() != 2) {
 				 System.out.print("Month must be in 2 digits\n");
 					getUserInputA();
 			}
 			// 3. Day
 			else if(dateOfBirth[2].length() != 2) {
 				 System.out.print("Day must be in 2 digits\n");
 					getUserInputA();
 			}
 			else {
 				//4. 
 				getUserInputB(personAInput);
 			}
 			
         } catch (ParseException e) {
        	 System.out.print("The format must be yyyy-mm-dd, dont forget the hyphen\n");
        	 getUserInputA();
         }
       
      }

	 /*
	  * Validate the input for person B
	  * 1. Separate the sting by the separator (-)
	  * 2. Check if the input is a date
	  * 3. Check if the input format is correct by comparing the length of each part 
	  * 4. Send the inputs to the calculate method.
	  */
  
    public static void validateInputB(String personBInput, String personAInput) {
    	//1. 
    	 String PersonB = personBInput; 
         String[] dateOfBirth = PersonB.split("-", 5);
         try {
        	 // 2.
             DateFormat checkIfDate = new SimpleDateFormat(DATE_FORMAT);
             checkIfDate.setLenient(false);
             checkIfDate.parse(personBInput);
             // 3. Year
 			if(dateOfBirth[0].length() != 4) {
 				 System.out.print("Year must be in 4 digits\n");
 					getUserInputA();
 			}
 			// 3. Month
 			else if(dateOfBirth[1].length() != 2) {
 				 System.out.print("Month must be in 2 digits\n");
 					getUserInputA();
 			}
 			//3. Day
 			else if(dateOfBirth[2].length() != 2) {
 				 System.out.print("Day must be in 2 digits\n");
 					getUserInputA();
 			}
 			// 4.
 			else {
 				 calculate(personAInput, personBInput);
 			}
         } catch (ParseException e) {
        	 System.out.print("The format must be yyyy-mm-dd, dont forget the hyphen\n");
        	getUserInputB(personAInput);
        	
         }

    }
    /*
     * Calculate the age difference in days
     * 1. Split the sting by the separator (-) and store in array.
     * 2. Assign variables for years, months and days from the array 
     * 3. Convert the string-array-parts to integer
     * 4a. Calculate how many days from person A till today
     * 4b. Calculate how many days from person B till today
     * 5. Check who's oldest
     * 6. Calculate the age difference (in days)
     */
    public static void calculate(String personAInput, String personBInput) {
    	// 1.
    	String PersonB = personBInput; 
   	 	String personA = personAInput; 
   	 	
   	 	// 2.
        String[] dateOfBirthB = PersonB.split("-", 5); 
   	 	String[] dateOfBirthA = personA.split("-", 5); 
   	 	
   	 	// 3.
   	 	int yearA =  Integer.parseInt(dateOfBirthA[0]);
   	 	int monthA =  Integer.parseInt(dateOfBirthA[1]);
   	 	int dayA =  Integer.parseInt(dateOfBirthA[2]);
        int yearB =  Integer.parseInt(dateOfBirthB[0]);
        int monthB =  Integer.parseInt(dateOfBirthB[1]);
        int dayB =  Integer.parseInt(dateOfBirthB[2]);

    	//4. Credit: https://stackoverflow.com/questions/48962098/calculate-the-users-age-in-days-java
 		LocalDate now = LocalDate.now();
 		LocalDate birthDatePersonA = LocalDate.of(yearA, monthA, dayA); //4a
 		LocalDate birthDatePersonB = LocalDate.of(yearB, monthB, dayB); // 4b
 		int personAAgeDays = (int) ChronoUnit.DAYS.between(birthDatePersonA, now); //4a
 		int personBAgeDays = (int) ChronoUnit.DAYS.between(birthDatePersonB, now); //4b
 		
 		// 5. Check who's oldest
 		if(personAAgeDays > personBAgeDays) {
 			//6.
 			int dayDifference = personAAgeDays - personBAgeDays;
 			System.out.println("Person A is older than Person B by "+ dayDifference+ " days.");	
 		} else {
 			//6.
 			int dayDifference = personBAgeDays - personAAgeDays;
 			System.out.println("Person B is older than Person A by "+ dayDifference+ " days.");
 		}
 		
    }
    }

