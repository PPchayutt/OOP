/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;

public class Ex12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("|");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
}
