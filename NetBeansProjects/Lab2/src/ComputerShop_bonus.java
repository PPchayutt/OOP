/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;

public class ComputerShop_bonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalPrice = 375.99;
        System.out.println("please insert your monitor size 38 or 43 only");
        int monitorSize = sc.nextInt();
        if (monitorSize == 38) {
            totalPrice += 75.99;
        } else if (monitorSize == 43) {
            totalPrice += 99.99;
        }
        System.out.println("Do you want DVD-ROM? 1 is Yes / 0 is No");
        int dvdChoice = sc.nextInt();
        System.out.println("Do you want printer? 1 is Yes / 0 is No");
        int printerChoice = sc.nextInt();
        System.out.println("======= Your order =======");
        System.out.println("* computer >>> 375.99$");
        if (monitorSize == 38) {
            System.out.println("* 38'Monitor >>> 75.99$");
        } else if (monitorSize == 43) {
            System.out.println("* 43'Monitor >>> 99.99$");
        }
        if (dvdChoice == 1) {
            System.out.println("* DVD-Rom >>> 65.99$");
            totalPrice += 65.99;
        }
        if (printerChoice == 1) {
            System.out.println("* Printer >>> 125.00$");
            totalPrice += 125.00;
        }
        System.out.println("======= Total price >>> " + totalPrice + " ==========");
    }
}
