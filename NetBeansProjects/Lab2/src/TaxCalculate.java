/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OPTO
 */
import java.util.*;

public class TaxCalculate {

    public static void main(String[] args) {
        double tax = 0, salary;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary: ");
        salary = sc.nextDouble();
        if (salary > 50000) {
            tax = salary * 0.1;
        } else if (salary <= 50000) {
            tax = salary * 0.05;
        }   
        System.out.println("Total tax is " + tax);
    }
}
