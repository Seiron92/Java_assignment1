/*
 * Date: 2020-09-18
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Codestrip {

    public static void main(String[] args) {

        // Call the method "readJavaFile"
        readJavaFile();
    }

    public static void readJavaFile() {
        // Read the text document
        Scanner txtscan;
        // Initialize variables
        int comments = 0;
        int blankLines = 0;
        int code = 0;
        int commentLines = 0;
        try {
            txtscan = new Scanner(new File("src/rj222nq_assign1/HelloWorld.java"));

            while (txtscan.hasNextLine()) {

                String text = txtscan.nextLine(); // Get the next line

                // count comments and lines
                if (text.trim().startsWith("/*") || text.trim().startsWith("//")) {
                    comments++;
                }
                /* remove all in-block comments i.e:
                 * 
                 Comment
                 */
                if (text.trim().startsWith("/*")) {
                    while (text.trim().startsWith("/*"))
                        text = text.replaceAll(txtscan.nextLine(), "");
                }
                // If a a line starts with any comment
                if (text.trim().startsWith("/*") || text.trim().endsWith("*/") || text.trim().startsWith("//") || text.trim().startsWith("*")) {

                    commentLines++; // Add the result as a comment (this adds 1 to every comment occurrence)

                }
                // Calculate all the blank lines
                if (text.trim().isEmpty()) {
                    blankLines++; // if blank line detected add this as a blank line
                }
                // If not a "blank line" 
                if (!text.trim().isEmpty()) {
                    code++; // Add this as code        	    	
                }
                // strip comments
                returnFile(text);
            }
            // Calculate removed blank lines, actual numbers of code and removed comments
            calculate(comments, blankLines, code, commentLines);
            txtscan.close();

        } catch (FileNotFoundException e) { // If something didn't worked out, display the error
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    // Calculate number of blank lines, comments and code
    public static void calculate(int comments, int blankLines, int code, int commentLines) {
        int numbersOfCode = code - commentLines; // Initialize the int variable numbersOfCode and assign the value of code - (minus) commentLines 
        System.out.println("Number of actual lines of code: " + numbersOfCode); // Present the numbers of actual code
        System.out.println("Number of blank lines removed: " + blankLines); // Present the numbers of blank lines
        System.out.println("Number of comments removed: " + comments); // Present the numbers of removed comments

    }

    /* Remove all comments from output */
    public static void returnFile(String text) {
        String str = text.trim(); // Remove all blank lines from the file and assign it to the variable str
        if (!str.isEmpty()) { // If the variable str isn't empty
            if (!str.startsWith("/") && !str.endsWith("/") && !str.startsWith("*")) { // and the code doesn't start with or ends with a comment
                System.out.println(text); // Present the code for the user
            }

        }
    }
}