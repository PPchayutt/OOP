/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;
public class TaxCalculate {
    public static void main(String[] args) {
        double totalPrice, price;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter price: ");
        price = input.nextDouble();
        totalPrice = price + (price * 0.07);
        System.out.println("Total price is " + totalPrice);
    }
}
