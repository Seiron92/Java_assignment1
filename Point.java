/*
 * Date: 2020-09-17
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;

public class Point {
    // Initialize variables
    private int x;
    private int y;

    public static void main(String[] args) {
        // Call the "getResult-method"
        getResult();
    }

    public Point() {
        // If x and y is "undetermined" set the values to 0
        x = 0;
        y = 0;
    }

    // Setter
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters (In order to assign/calculate values separately)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Convert the result to string and separate the result with a comma
    public String toString() {
        return x + "," + y;
    }

    // Return true if the 2 points are equal
    private boolean isEqualTo(Point p2) {
        return x == p2.getX() && y == p2.getY();

    }

    // Move the points accordingly to the "input"
    public void move(int i, int j) {
        x = getX() + i; // Get the current point (X) and add the input of i
        y = getY() + j; // Get the current point (Y) and add the input of j
    }
    public void moveToXY(int i, int j) {
        x = getX() + i; // Get the current point (X) and add the input of i
        y = getY() + j; // Get the current point (Y) and add the input of j
    }

    // Calculate the distance to the 2 points
    // Credit: https://javatutoring.com/distance-between-two-points-java-program/
    private double distanceTo(Point p2) {
        double dis; // Initialize a new double
        double x1 = getX(); // Initialize and assign the variable x1 to the current point (X)
        double y1 = getY(); // Initialize and assign the variable y1 to the current point (Y)
        double x2 = p2.getX(); // Initialize and assign the variable x2 to the current point (X) with the value of p2
        double y2 = p2.getY(); // Initialize and assign the variable y2 to the current point (Y) with the value of p2
        // Calculate the distance between the 2 points by calculating the square root of the separate sum of points
        dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        // Return the distance  
        return dis;
    }

    // Get the result
    public static void getResult() {
        Point p1 = new Point();
        Point p2 = new Point(3, 4);
        System.out.println(p1.toString()); // ==> (0,0)
        System.out.println(p2.toString()); // ==> (3,4)
        if (p1.isEqualTo(p2)) // False!
            System.out.println("The two points are equal");
        double dist = p1.distanceTo(p2);

        System.out.println("Point Distance: " + dist);
        p2.move(5, -2); // ==> (8,2)
        p1.moveToXY(8, 2); // ==> (8,2)
        if (p1.isEqualTo(p2)) // True!
            System.out.println("The two points are equal");
    }
}