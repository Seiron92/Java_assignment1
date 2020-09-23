/*
 * Date: 2020-09-18
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;

public class Invoice {
    //Initialize variables
    private String number;
    private String description;
    private int quantity;
    private double price;

    // Getters
    public String getNumber() {
        return number;
    }
    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public Double getPrice() {
        return price;
    }

    // Setters
    public void setNumber(String newNumber) {
        this.number = newNumber;
    }
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
    public void setPrice(Double newPrice) {
        this.price = newPrice;
    }

    public static void main(String[] args) {

        // call the method "InvoiceTest" and pass along your variables
        InvoiceResult("item001", "Apples", 10.0, 5);
    }
    // Get the invoice amount
    public static Double getInvoiceAmount(double price, int quantity) {
        Invoice items = new Invoice(); // Get the "Invoice blueprint"
        items.price = price; // Set the price to the "input-price" 
        items.quantity = quantity; // Set the quantity to the "input-quantity"
        return items.price * items.quantity; // Return the product of the price and quantity 
    }

    public static void InvoiceResult(String number, String description, double price, int quantity) {
        // If the price is less than 0
        if (price < 0) {
            price = 0.0; // Set the price to 0
        }
        // If the quantity is less than 0
        if (quantity < 0) {
            quantity = 0; // Set the quantity to 0
        }
        Invoice items = new Invoice(); // Get the "blueprint" of the invoice object
        String num = items.number = number; // Initialize the variable string num and assign the invoice number to the passed number
        String desc = items.description = description; // Initialize the variable string desc and assign the invoice description to the passed description
        double total = getInvoiceAmount(price, quantity); // Calculate the total by passing the price and the quantity to the "GetInvoiceAmount-method"
        // Display the result to the user
        System.out.println("Item number: " + num + "\nDescription: " + desc + "\nPrice per piece: " + price + "\nQuantity: " + quantity + "\nTotal: " + total);
    }
}