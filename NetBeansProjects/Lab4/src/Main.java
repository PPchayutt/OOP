/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyAdd2 obj = new MyAdd2();
        System.out.println("Please insert number1 : ");
        int x = sc.nextInt();
        System.out.println("Please insert number2 : ");
        int num = sc.nextInt();
        int result = obj.AddTwo(x);
        System.out.println("The result#1 is " + result);
        result = obj.AddNum(x + 5, num);
        System.out.println("The result#2 is " + result);
        result = obj.AddTwo(x * 3 + 2);
        System.out.println("The result#3 is " + result);

    }
}

class MyAdd2 {

    public int AddTwo(int a) {
        return AddNum(a, 2);
    }

    public int AddNum(int a, int num) {
        return (a + num);
    }
}
