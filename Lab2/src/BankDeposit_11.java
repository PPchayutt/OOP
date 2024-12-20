/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;

public class BankDeposit_11 {

    public static void main(String[] args) {
        double money, totalMoney = 0;
        char accType;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your money : ");
        money = sc.nextDouble();
        System.out.print("Input your account type (Please type A B C or X in uppercase) : ");
        accType = sc.next().charAt(0);
        if (accType == 'A' | accType == 'C') {
            totalMoney = money + (money * 0.015);
        } else if (accType == 'B') {
            totalMoney = money + (money * 0.02);
        } else if (accType == 'X') {
            totalMoney = money + (money * 0.05);
        }
        System.out.println("Your total money in one year = " + totalMoney);
    }
}
