/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OPTO
 */
import java.util.*;

public class demo {

    public static void main(String[] args) {
        String fruit = "Banana";
        int priceX = 32;
        int priceY = 64;
        if(fruit.length() == 6) {
            if (priceX * 2 > priceY) {
                System.out.print("A");
            } else {
                System.out.print("B");
            }
        } else {
            System.out.print("C");
        } 
    }
}
