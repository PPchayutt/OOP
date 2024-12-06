/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;
public class TimeConverter {
    public static void main(String[] args) {
        double hours, mins, secs, totalmins;
        Scanner input = new Scanner(System.in);
        System.out.print("Hours : ");
        hours = input.nextDouble();
        System.out.print("Mins : ");
        mins = input.nextDouble();
        totalmins = (hours * 60) + mins;
        secs = totalmins * 60;
        System.out.println("Secs = " + secs);
    }
}
