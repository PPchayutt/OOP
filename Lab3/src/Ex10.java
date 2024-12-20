/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;

public class Ex10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int evenCount = 0;
        int oddCount = 0;
        while (true) {
            num = sc.nextInt();
            if (num == -1) {
                break;
            }
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Odd number = " + oddCount + " and Even number = " + evenCount);
    }
}
