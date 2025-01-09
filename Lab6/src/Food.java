/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
public class Food {

    private static final int energy = 10;
    private static double price = 50;

    public static void setPrice(double price) {
        if (price > Food.price) {
            Food.price = price;
        } else {
            System.out.println("Cannot update the food price.");
        }
    }

    public static double getPrice() {
        return price;
    }

    public static int getEnergy() {
        return energy;
    }
}
