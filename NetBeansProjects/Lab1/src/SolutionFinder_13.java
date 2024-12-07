/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OPTO
 */
public class SolutionFinder_13 {
    public static void main(String[] args) {
        double a = 4, b = 8, c = 3;
        double x1 = (-b + (Math.sqrt(b * b - (4 * a * c)))) / (2 * a);
        double x2 = (-b - (Math.sqrt(b * b - (4 * a * c)))) / (2 * a);
        System.out.println(x1);
        System.out.println(x2);
    }
}
